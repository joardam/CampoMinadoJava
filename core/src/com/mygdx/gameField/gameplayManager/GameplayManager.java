package com.mygdx.gameField.gameplayManager;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.*;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.WarningSafeCell;
import com.mygdx.gameField.cell.characteristics.explosionState.Exploded;
import com.mygdx.gameField.cell.characteristics.state.Uncovered;
import com.mygdx.gameField.cell.characteristics.state.covered.NotFlagged;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;
import com.mygdx.gameField.gameplayManager.gameStatus.Looser;
import com.mygdx.gameField.gameplayManager.gameStatus.Winner;
import com.mygdx.utils.GameUtils;

public abstract class GameplayManager {
	protected boolean winStatus = false;
	protected boolean gameOverStatus = false;
	
	protected GameStatus gameStatus;
	
	
	
	 public void tryToUncoverThisCell(int posX ,int posY, Field field) {
	    	

	        FieldCell[][] cells = field.getCells();
	        FieldCell cell = cells[posX][posY];
	        int count = 0;
	       
	        cell.getCharacteristics().startAnalyzeInteraction();
	        cell.analyzeLoss(gameStatus);
	        
	        
	        if (cell.getCharacteristics().getExplosionState() instanceof Exploded) {
	        	gameOverStatus = true;
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
	        	this.gameStatus.declareWin();
	        	this.winStatus = true;
	        	explodeField(cell,cells);
	        }
	        
	        
	        
	        
	        if((gameOverStatus == true) || (winStatus == true)) {
	        	return;
	        }
	        
	        
	    }
	
    public void tryToToggleFlagThisCell(int posX,int posY, Field field) {
        FieldCell cell = field.getCells()[posX][posY];
        cell.interactFlag();
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

   
  
    
    
    
    
    
    public boolean getGameOverStatus() {
    	return this.gameOverStatus;
    }


    public boolean isWinStatus() {
		return winStatus;
	}
    
    
    public void declareWin() {
    	this.gameStatus = new Winner(this); 
    }
    
    public void declareLoss() {
    	this.gameStatus = new Looser(this);
    }

    
    
}
