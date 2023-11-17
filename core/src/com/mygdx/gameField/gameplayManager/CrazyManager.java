package com.mygdx.gameField.gameplayManager;


import com.mygdx.gameField.CrazyField;
import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.CrazyModeCell;
import com.mygdx.gameField.cell.cellType.MinedCell;
import com.mygdx.gameField.cell.cellType.SafeCell;
import com.mygdx.gameField.cell.state.UncoveredCellState;
import com.mygdx.utils.GameUtils;

public class CrazyManager extends GameplayManager {
	 private int crazyPercentage = 100;
	
	 
	 @Override
	 public void tryToToggleFlagThisCell(int posX,int posY, Field field) {
	        
			super.tryToToggleFlagThisCell(posX, posY, field);
	        CrazyModeCell cell = (CrazyModeCell) field.getCells()[posX][posY];
	        
	        if(cell.getCellState() instanceof UncoveredCellState) {
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
	        
	        if(cell.getCellType() instanceof SafeCell) {
	        	cell.setCellType(new MinedCell());
	        	cell.activate();
	        	((CrazyField) field).increaseBombsQuantity();
	        	 field.placeCountersInSafeCells();
	        	
	        	
	        }
	        else {
	        	cell.setCellType(new SafeCell());
	        	cell.activate();
	        	((CrazyField) field).decreaseBombsQuantity();
	        	 field.placeCountersInSafeCells();
	        	 super.tryToToggleFlagThisCell(posX, posY, field);
	        	 super.tryToUncoverThisCell(posX, posY, field);
	        }
	        
	       
	        
	    }
}
