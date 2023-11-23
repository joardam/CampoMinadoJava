package com.mygdx.gameField.gameplayManager;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.*;
import com.mygdx.gameField.cell.cellProfile.MinedCell;
import com.mygdx.gameField.cell.cellProfile.safeCell.CompleteSafeCell;
import com.mygdx.gameField.cell.cellProfile.safeCell.WarningSafeCell;
import com.mygdx.gameField.cell.cellState.Uncovered;
import com.mygdx.gameField.cell.cellState.coveredCellState.NotFlagged;
import com.mygdx.utils.GameUtils;

public abstract class GameplayManager {
	protected boolean winStatus = false;
	protected boolean gameOverStatus = false;


	
	
	
	 public void tryToUncoverThisCell(int posX ,int posY, Field field) {
	    	

	        FieldCell[][] cells = field.getCells();
	        FieldCell cell = cells[posX][posY];
	        int count = 0;
	       
	        
	        if((cell.getCellState() instanceof NotFlagged ) && ((NotFlagged) cell.getCellState()).isFlagged()) {
	        	return;
	        }
	        
	        if(cell.getCellState() instanceof Uncovered) {
	        	return;
	        }
	        
	        if (cell.getCellType() instanceof CompleteSafeCell || cell.getCellType() instanceof WarningSafeCell) {
	            boolean[][] virtualArrayForFieldCheck = new boolean[cells.length][cells[0].length];
	            uncoverFlood(cells, posX, posY, virtualArrayForFieldCheck , "no");
	            
	        }
	        
	        
	        for (int i = 0; i < cells.length; i++) {
		        for (int j = 0; j < cells[i].length; j++) {
		            FieldCell currentCell = cells[i][j];
		            if(currentCell.getCellState() instanceof Uncovered) {
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
        FieldCell cell = field.getCells()[posX][posY];
        if(!(cell.getCellState() instanceof NotFlagged)) {
			return;
		}
        cell.toggleFlagState();
    }

    public  void explodeField(FieldCell cell, FieldCell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (!(cells[i][j].getCellState() instanceof Uncovered)) {
                	cells[i][j].setCellStateUncovered();
                }
            }
        }
    }

    public  void uncoverFlood(FieldCell[][] cells, int arrayPosX, int arrayPosY, boolean[][] virtualArrayCheck , String state) {
    	
    	if (!GameUtils.isIn2DArrayBound(arrayPosX, arrayPosY, cells.length, cells[0].length) ||
                virtualArrayCheck[arrayPosX][arrayPosY] ||
                (cells[arrayPosX][arrayPosY].getCellType() instanceof MinedCell)) {
            return;
        }
    	
    	

        if (cells[arrayPosX][arrayPosY].getCellType() instanceof WarningSafeCell) {

           
            cells[arrayPosX][arrayPosY].setCellStateUncovered();
           
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
        	cells[arrayPosX][arrayPosY].setCellStateUncovered();
            
            
  
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

    

    
    
}
