package com.mygdx.gameField;

import com.mygdx.gameField.cell.CellStructureManager;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.MinedCell;
import com.mygdx.gameField.cell.SafeCell;
import com.mygdx.gameField.cell.state.UncoveredCellState;
import com.mygdx.gameField.cell.state.covered.CoveredCellAndFlaggedState;
import com.mygdx.gameField.round.Rounds;
import com.mygdx.players.Players;
import com.mygdx.utils.Utils;

public class GameplayManager {

	private Rounds rounds = new Rounds();
	
	
	private boolean winStatus = false;
	private boolean gameOverStatus = false;
	private int cellsDiscovered = 0;
	
	
	public GameplayManager() {
		
	}
	
	
	 public void tryToUncoverThisCell(int posX ,int posY, GameField field) {
	    	

	        FieldCell[][] cells = field.getCells();
	        FieldCell cell = cells[posX][posY];
	       
	        
	        if(cell.getCellState() instanceof CoveredCellAndFlaggedState) {
	        	return;
	        }
	        
	        if(cell.getCellState() instanceof UncoveredCellState) {
	        	return;
	        }
	        
	        if (cell instanceof SafeCell) {
	            boolean[][] virtualArrayForFieldCheck = new boolean[cells.length][cells[0].length];
	            uncoverFlood(cells, posX, posY, virtualArrayForFieldCheck);
	            field.decreaseCellsNumber(this.cellsDiscovered);
	            this.cellsDiscovered = 0;
	            
	        }
	        
	        if (cell instanceof MinedCell) {
	            explodeField(cell, cells);
	            this.gameOverStatus = true;
	        }
	        
	        if(field.getBombsQuantity() == field.getCoveredCellsNumber()) {
	        	this.winStatus = true;
	        	explodeField(cell,cells);
	        }
	        
	        if((gameOverStatus == true) || (winStatus == true)) {
	        	return;
	        }
	        
	        
	    }
	
	
	
	
    public void tryToUncoverThisCell(int posX ,int posY, GameField field ,Players players ) {
    	

        FieldCell[][] cells = field.getCells();
        FieldCell cell = cells[posX][posY];
       
        
        if(cell.getCellState() instanceof CoveredCellAndFlaggedState) {
        	return;
        }
        
        if(cell.getCellState() instanceof UncoveredCellState) {
        	return;
        }
        
        if (cell instanceof SafeCell) {
            boolean[][] virtualArrayForFieldCheck = new boolean[cells.length][cells[0].length];
            uncoverFlood(cells, posX, posY, virtualArrayForFieldCheck);
            field.decreaseCellsNumber(this.cellsDiscovered);
            this.cellsDiscovered = 0;
            
        }
        
        if (cell instanceof MinedCell) {
            explodeField(cell, cells);
            this.gameOverStatus = true;
        }
        
        if(field.getBombsQuantity() == field.getCoveredCellsNumber()) {
        	this.winStatus = true;
        	explodeField(cell,cells);
        }
        
        if((gameOverStatus == true) || (winStatus == true)) {
        	return;
        }
        
        this.rounds.passPlayerRound(players);
        
    }

    public void tryToToggleFlagThisCell(int posX,int posY, GameField field) {
       
        FieldCell cell = field.getCells()[posX][posY];
        CellStructureManager.ToggleFlagCell(cell);
    }

    public  void explodeField(FieldCell cell, FieldCell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (!(cells[i][j].getCellState() instanceof UncoveredCellState)) {
                    CellStructureManager.forceUncoverCell(cells[i][j]);
                }
            }
        }
    }

    public  void uncoverFlood(FieldCell[][] cells, int arrayPosX, int arrayPosY, boolean[][] virtualArrayForFieldCheck) {
    	
    	if (!Utils.isIn2DArrayBound(arrayPosX, arrayPosY, cells.length, cells[0].length) ||
                virtualArrayForFieldCheck[arrayPosX][arrayPosY] ||
                (cells[arrayPosX][arrayPosY] instanceof MinedCell)) {
            return;
        }

        if (cells[arrayPosX][arrayPosY] instanceof SafeCell &&
                ((SafeCell) cells[arrayPosX][arrayPosY]).getNearBombs() != 0) {

            CellStructureManager.forceUncoverCell(cells[arrayPosX][arrayPosY]);
            
            cellsDiscovered++;
            
            virtualArrayForFieldCheck[arrayPosX][arrayPosY] = true;

            for (int k = -1; k <= 1; k++) {
                int loopX = arrayPosX + k;
                int loopY = arrayPosY + k;
                
                
                if (Utils.isIn2DArrayBound(loopX, arrayPosY, cells.length, cells[0].length)) {
                    boolean isVirtualArraySet = virtualArrayForFieldCheck[loopX][arrayPosY];
                    boolean isSafeCell = cells[loopX][arrayPosY] instanceof SafeCell;
                    boolean hasNoNearBombs = isSafeCell && ((SafeCell) cells[loopX][arrayPosY]).getNearBombs() == 0;

                    if (isVirtualArraySet && isSafeCell && hasNoNearBombs) {
                        loopEdges(virtualArrayForFieldCheck, cells, loopX, arrayPosY);
                    }
                }

                if (Utils.isIn2DArrayBound(arrayPosX, loopY, cells.length, cells[0].length)) {
                    boolean isVirtualArraySet = virtualArrayForFieldCheck[arrayPosX][loopY];
                    boolean isSafeCell = cells[arrayPosX][loopY] instanceof SafeCell;
                    boolean hasNoNearBombs = isSafeCell && ((SafeCell) cells[arrayPosX][loopY]).getNearBombs() == 0;

                    if (isVirtualArraySet && isSafeCell && hasNoNearBombs) {
                        loopEdges(virtualArrayForFieldCheck, cells, arrayPosX, loopY);
                    }
                }

            }
            return;
        }

        virtualArrayForFieldCheck[arrayPosX][arrayPosY] = true;

        if (!(cells[arrayPosX][arrayPosY] instanceof MinedCell)) {
            CellStructureManager.forceUncoverCell(cells[arrayPosX][arrayPosY]);
            
            cellsDiscovered++;
  
            uncoverFlood(cells, arrayPosX - 1, arrayPosY, virtualArrayForFieldCheck);
            uncoverFlood(cells, arrayPosX + 1, arrayPosY, virtualArrayForFieldCheck);
            uncoverFlood(cells, arrayPosX, arrayPosY - 1, virtualArrayForFieldCheck);
            uncoverFlood(cells, arrayPosX, arrayPosY + 1, virtualArrayForFieldCheck);
        }
    }

    public  void loopEdges(boolean[][] virtualArrayForFieldCheck, FieldCell[][] cells, int x, int y) {
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                int loopX = x + k;
                int loopY = y + l;
                uncoverFlood(cells, loopX, loopY, virtualArrayForFieldCheck);
                l++;
            }
            k++;
        }
    }
    
    public boolean getGameOverStatus() {
    	return this.gameOverStatus;
    }


    public boolean isWinStatus() {
		return winStatus;
	}

    
    
	public Rounds getRounds() {
		return rounds;
	}
    
    
    
}
