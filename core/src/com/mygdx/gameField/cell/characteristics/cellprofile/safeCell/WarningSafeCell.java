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

	
	public void setNearbyBombs(int counter) {
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

	
	
	

}
