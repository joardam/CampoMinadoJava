package com.mygdx.gameField.cell.characteristics.cellprofile.safeCell;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;

public class WarningSafeCell extends SafeCell {

	int nearbyBombs;
	
	
	@Override
	public void revealInteract(FieldCell cell) {
		return;
		
	}

	@Override
	public void flagInteract(FieldCell cell) {
		return;
		
	}

	
	
	public void setNearbyBombsCounter(int counter) {
		this.nearbyBombs = counter;
	}

	public int getNearbyBombs() {
		return nearbyBombs;
	}



	@Override
	public int getCellTextureId() {
		return nearbyBombs;
	}

	@Override
	public void analyzeStart(Characteristics characteristics, Field field) {
		characteristics.uncover();
		
	}

	@Override
	public void analyzeWorking(Characteristics characteristics, Field field) {
		characteristics.uncover();
		return;
		
	}

	@Override
	public void setNearbyBombs(FieldCell cell) {
		return;
	}

	@Override
	public void resetNearbyBombs(FieldCell cell) {
		int counterBombs = 0;
		for (int i = 0; i <= 7; i++) {
			if (cell.getNearCells().getNearCellsArray()[i] == null) {
				// pass
			} else {
				counterBombs = cell.getNearCells().getNearCellsArray()[i].getProfile().countBomb(counterBombs);
			}

			if (counterBombs > 0) {
				cell.setCellProfileCompleteSafeCell();
				cell.getProfile().setNearbyBombs(cell);

				((WarningSafeCell) cell.getProfile()).setNearbyBombsCounter(counterBombs);

			}
			else {
				
			}
		}
	}
	
	

}
