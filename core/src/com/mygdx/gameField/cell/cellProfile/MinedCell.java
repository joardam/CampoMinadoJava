package com.mygdx.gameField.cell.cellProfile;

import com.mygdx.gameField.cell.FieldCell;

public class MinedCell extends CellProfile {

	@Override
	public void revealInteract(FieldCell cell) {
		                                                                     
	}

	@Override
	public void flagInteract(FieldCell cell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void analyzeInWorking(FieldCell cell , String sideInteraction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void analyzeStart(FieldCell cell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNearbyBombs(FieldCell cell) {
		return;
		
	}
	
	@Override
	public int countBomb(int counter) {
		counter++;
		return counter ;
		
	}

	
}
