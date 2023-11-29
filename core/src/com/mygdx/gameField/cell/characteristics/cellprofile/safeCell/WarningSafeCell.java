package com.mygdx.gameField.cell.characteristics.cellprofile.safeCell;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;

public class WarningSafeCell extends SafeCell {

	int nearbyBombs;
	
	
	@Override
	public void revealInteract(FieldCell cell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flagInteract(FieldCell cell) {
		// TODO Auto-generated method stub
		
	}

	



	
	
	public void setNearbyBombs(int counter) {
		this.nearbyBombs = counter;
	}

	public int getNearbyBombs() {
		return nearbyBombs;
	}

	@Override
	public void analyzeStart(Characteristics characteristics) {
		characteristics.uncover();
		return;
		
	}

	@Override
	public void analyzeWorking(Characteristics characteristics) {
		characteristics.uncover();
		return;
	}

	@Override
	public int getCellTextureId() {
		return nearbyBombs;
	}

	
	
	

}
