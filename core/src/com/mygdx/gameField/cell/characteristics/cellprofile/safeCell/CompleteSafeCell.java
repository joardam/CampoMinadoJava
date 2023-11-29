package com.mygdx.gameField.cell.characteristics.cellprofile.safeCell;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.cellprofile.CellProfile;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;

public class CompleteSafeCell extends SafeCell{
	

	
	public CompleteSafeCell() {
		
	}

	@Override
	public void flagInteract(FieldCell cell) {
		
	}

	@Override
	public void revealInteract(FieldCell cell) {
		
		
	}
	
	
	

	

	
	
	
	
	@Override
	public void setNearbyBombs(FieldCell cell) {
		int counterBombs = 0;
		
		
			for(int i = 0 ; i <= 7 ;i++){
				if (cell.getNearCells().getNearCellsArray()[i] == null) {
					//pass
				} else {
					counterBombs = cell.getNearCells().getNearCellsArray()[i].getProfile().countBomb(counterBombs);
				}
		
				
    				
		
		
		if(counterBombs > 0) {
			cell.setCellProfileWarningSafeCell();
			cell.getProfile().setNearbyBombs(cell);
			((WarningSafeCell)cell.getProfile()).setNearbyBombs(counterBombs);
		}
		
		
		
	}

	}

	@Override
	public void analyzeStart(Characteristics characteristics) {
		characteristics.analyzeWorking();
		
	}

	@Override
	public void analyzeWorking(Characteristics characteristics) {
		characteristics.uncover();
		characteristics.analyzeWorking();
	}

	@Override
	public int getCellTextureId() {
		return 0;
	}

	
}

