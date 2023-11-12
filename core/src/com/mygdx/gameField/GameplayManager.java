package com.mygdx.gameField;

import com.mygdx.gameField.cell.*;
import com.mygdx.gameField.cell.cellType.MinedCell;
import com.mygdx.gameField.cell.cellType.SafeCell;
import com.mygdx.gameField.cell.state.CoveredCellState;
import com.mygdx.gameField.cell.state.UncoveredCellState;
import com.mygdx.gameField.round.Rounds;
import com.mygdx.utils.Utils;

public abstract class GameplayManager {
	protected Rounds rounds = new Rounds();
	protected boolean winStatus = false;
	protected boolean gameOverStatus = false;

	
	
	
	 public void tryToUncoverThisCell(int posX ,int posY, ClassicField field) {
	    	

	        FieldCell[][] cells = field.getCells();
	        FieldCell cell = cells[posX][posY];
	        int count = 0;
	       
	        
	        if((cell.getCellState() instanceof CoveredCellState ) && ((CoveredCellState) cell.getCellState()).isFlagged()) {
	        	return;
	        }
	        
	        if(cell.getCellState() instanceof UncoveredCellState) {
	        	return;
	        }
	        
	        if (cell.getCellType() instanceof SafeCell) {
	            boolean[][] virtualArrayForFieldCheck = new boolean[cells.length][cells[0].length];
	            uncoverFlood(cells, posX, posY, virtualArrayForFieldCheck , "no");
	            
	        }
	        
	        
	        for (int i = 0; i < cells.length; i++) {
		        for (int j = 0; j < cells[i].length; j++) {
		            FieldCell currentCell = cells[i][j];
		            if(currentCell.getCellState() instanceof UncoveredCellState) {
		            	count++;
		            }
		   
		        }
	        }
	        
	        
	        if(field.getBombsQuantity() == (field.getCoveredCellsNumber() - count)) {
	        	this.winStatus = true;
	        	explodeField(cell,cells);
	        }
	        
	        
	        if (cell.getCellType() instanceof MinedCell) {
	            explodeField(cell, cells);
	            this.gameOverStatus = true;
	        }
	       
	        
	        
	        if((gameOverStatus == true) || (winStatus == true)) {
	        	return;
	        }
	        
	        
	    }
	
	


    public void tryToToggleFlagThisCell(int posX,int posY, Field field) {
        ClassicCell cell = field.getCells()[posX][posY];
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

    public  void uncoverFlood(FieldCell[][] cells, int arrayPosX, int arrayPosY, boolean[][] virtualArrayCheck , String state) {
    	
    	if (!Utils.isIn2DArrayBound(arrayPosX, arrayPosY, cells.length, cells[0].length) ||
                virtualArrayCheck[arrayPosX][arrayPosY] ||
                (cells[arrayPosX][arrayPosY].getCellType() instanceof MinedCell)) {
            return;
        }
    	
    	

        if (cells[arrayPosX][arrayPosY].getCellType() instanceof SafeCell &&
                cells[arrayPosX][arrayPosY].getNearBombs() != 0) {

            CellStructureManager.forceUncoverCell(cells[arrayPosX][arrayPosY]);
            virtualArrayCheck[arrayPosX][arrayPosY] = true;
            
           
           if(state.equals("no")) {
        	   return;
           } 
           
           if((state.equals("ve"))) {
        	   uncoverFlood(cells , arrayPosX - 1 , arrayPosY , virtualArrayCheck ,"no");
        	   uncoverFlood(cells , arrayPosX + 1, arrayPosY ,  virtualArrayCheck ,"no");
           }
           if((state.equals("ho"))) {
        	   uncoverFlood(cells , arrayPosX , arrayPosY - 1, virtualArrayCheck , "no");
        	   uncoverFlood(cells , arrayPosX, arrayPosY  + 1, virtualArrayCheck , "no");
           }
           
            return;
        }

        	virtualArrayCheck[arrayPosX][arrayPosY] = true;
            CellStructureManager.forceUncoverCell(cells[arrayPosX][arrayPosY]);
            
  
            uncoverFlood(cells, arrayPosX - 1, arrayPosY, virtualArrayCheck , "ho");
            uncoverFlood(cells, arrayPosX + 1, arrayPosY, virtualArrayCheck , "ho");
            uncoverFlood(cells, arrayPosX, arrayPosY - 1, virtualArrayCheck , "ve");
            uncoverFlood(cells, arrayPosX, arrayPosY + 1, virtualArrayCheck,  "ve");

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
