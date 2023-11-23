package com.mygdx.gameField.cell.cellProfile.safeCell;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.cellProfile.CellProfile;

public class CompleteSafeCell extends SafeCell{
	
	
	
	
	
	public CompleteSafeCell() {
		
	}

	@Override
	public void flagInteract(FieldCell cell) {
		
	}

	@Override
	public void revealInteract(FieldCell cell) {
		
		cell.getCellState().analyzeStart(cell);
		
		
	}
	
	@Override
	public void analyzeInWorking(FieldCell cell , String sideInteraction) {
		
		FieldCell bottomCell = cell.getNearCells().getBottomCenterCell();
		FieldCell upperCell = cell.getNearCells().getTopCenterCell();
		FieldCell rigthCell = cell.getNearCells().getMiddleRightCell();
		FieldCell leftCell  = cell.getNearCells().getMiddleLeftCell();
		
		bottomCell.getCellState().analyzeInWorking(bottomCell , "dw");
		upperCell.getCellState().analyzeInWorking(upperCell ,"up");
		rigthCell.getCellState().analyzeInWorking(rigthCell ,"rt");
		leftCell.getCellState().analyzeInWorking(leftCell ,"lt");
		
	}
	
	

	@Override
	public void analyzeStart(FieldCell cell) {
		analyzeInWorking(cell , null);
		
	}

	
	
	
	
	@Override
	public void setNearbyBombs(FieldCell cell) {
		int counterBombs = 0;
		
		
			for(int i = 0 ; i <= 7 ;i++){
				if (cell.getNearCells().getNearCellsArray()[i] == null) {
					//pass
				} else {
					counterBombs = cell.getNearCells().getNearCellsArray()[i].getCellType().countBomb(counterBombs);
				}
		
				
    				
		
		
		if(counterBombs > 0) {
			cell.setCellProfileWarningSafeCell();
			cell.getCellType().setNearbyBombs(cell);
			((WarningSafeCell)cell.getCellType()).setNearbyBombs(counterBombs);
		}
		
		
		
	}
	

	 

	}
}

