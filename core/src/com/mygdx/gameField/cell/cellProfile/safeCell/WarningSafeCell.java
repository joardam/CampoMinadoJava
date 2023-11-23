package com.mygdx.gameField.cell.cellProfile.safeCell;

import com.mygdx.gameField.cell.FieldCell;

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

	@Override
	public void analyzeStart(FieldCell cell) {
		return;
		
	}

	@Override
	public void analyzeInWorking(FieldCell cell, String sideInteraction) {
		//do the observation based on the sideInteraction
		return;
	}

	
	
	public void setNearbyBombs(int counter) {
		this.nearbyBombs = counter;
	}

	public int getNearbyBombs() {
		return nearbyBombs;
	}

	
	
	

}
