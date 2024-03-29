package com.mygdx.gameField.gameplayManager;


import com.mygdx.gameField.CrazyField;
import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.CrazyModeCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCell;
import com.mygdx.gameField.cell.characteristics.state.Uncovered;
import com.mygdx.utils.GameUtils;

public class CrazyManager extends GameplayManager {
	 private int crazyPercentage = 100;
	
	 
	 @Override
	 public void tryToToggleFlagThisCell(int posX,int posY, Field field) {
	        
			super.tryToToggleFlagThisCell(posX, posY, field);
	        CrazyModeCell cell = (CrazyModeCell) field.getCells()[posX][posY];
	        
	        if(cell.getCellState() instanceof Uncovered) {
	        	return;
	        }
	        
	        if (!cell.isCrazyCell()) {
	        	return;
	        }
	        
	        if(cell.isActivated()) {
	        	return;
	        }
	        
	        
	        int number = GameUtils.randomBetween(1,100);
	        
	        if(!(number <= crazyPercentage)) {
	        	return;
	        }
	        
	        if(cell.getProfile() instanceof CompleteSafeCell) {
	        	cell.setProfile(new MinedCell());
	        	cell.activate();
	        	((CrazyField) field).increaseBombsQuantity();
	        	 field.replaceCountersInSafeCells();
	        	
	        	
	        }
	        else {
	        	cell.setProfile(new CompleteSafeCell());
	        	cell.activate();
	        	((CrazyField) field).decreaseBombsQuantity();
	        	 field.replaceCountersInSafeCells();
	        	 super.tryToToggleFlagThisCell(posX, posY, field);
	        	 super.tryToUncoverThisCell(posX, posY, field);
	        }
	        
	       
	        
	    }
}
