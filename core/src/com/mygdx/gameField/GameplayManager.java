package com.mygdx.gameField;

import com.mygdx.gameField.cell.CellStructureManager;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.MinedCell;
import com.mygdx.gameField.cell.SafeCell;
import com.mygdx.gameField.cell.state.UncoveredCellState;
import com.mygdx.gameField.cell.state.covered.CoveredCellAndFlaggedState;
import com.mygdx.gameField.round.Rounds;
import com.mygdx.mouseTrack.MouseTrack;
import com.mygdx.players.Player;
import com.mygdx.players.Players;
import com.mygdx.utils.Utils;

public class GameplayManager {

	private Rounds rounds = new Rounds();
	
	private boolean gameOverStatus = false;
	
	Player looser;
	
	public GameplayManager() {
		
		
	}
	
	
	
    public void tryToUncoverThisCell(MouseTrack mouse, GameField field ,Players players) {
        int posX = mouse.getMouseCordinates().getCoordinateX();
        int posY = mouse.getMouseCordinates().getCoordinateY();

        FieldCell[][] cells = field.getCells();
        FieldCell cell = cells[posX][posY];
        CellStructureManager.UncoverCell(cell);
        
        
        
        if(cell.getCellState() instanceof CoveredCellAndFlaggedState) {
        	return;
        }
        if (cell instanceof MinedCell && !(cell.getCellState() instanceof CoveredCellAndFlaggedState)) {
            explodeField(cell, cells);
            this.gameOverStatus = true;
            looser = players.getPlayerByIndex(rounds.getPlayerIdInRound());
        }

        if (cell instanceof SafeCell && ((SafeCell) cell).getNearBombs() == 0 ) {
            boolean[][] virtualArrayForFieldCheck = new boolean[cells.length][cells[0].length];
            uncoverFlood(cells, posX, posY, virtualArrayForFieldCheck);
        }
        
        if (!(gameOverStatus)) {
        	this.rounds.passPlayerRound(players);
        	}
        
        
    }

    public void tryToToggleFlagThisCell(MouseTrack mouse, GameField field) {
        int posX = mouse.getMouseCordinates().getCoordinateX();
        int posY = mouse.getMouseCordinates().getCoordinateY();

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



	public Rounds getRounds() {
		return rounds;
	}
    
    
    
}
