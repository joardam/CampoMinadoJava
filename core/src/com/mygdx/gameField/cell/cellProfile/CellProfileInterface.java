package com.mygdx.gameField.cell.cellProfile;

import com.mygdx.gameField.cell.FieldCell;

public interface CellProfileInterface {
	public void revealInteract(FieldCell cell);
	void flagInteract(FieldCell cell);
	public void analyzeStart(FieldCell cell);
	public void analyzeInWorking(FieldCell cell , String sideInteraction);
	public void setNearbyBombs(FieldCell cell);
	public int countBomb(int counter);
	
		
	
}
