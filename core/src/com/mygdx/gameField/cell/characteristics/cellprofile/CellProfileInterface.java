package com.mygdx.gameField.cell.characteristics.cellprofile;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;

public interface CellProfileInterface {
	
	public void revealInteract(FieldCell cell);
	void flagInteract(FieldCell cell);
	public void analyzeStart(Characteristics characteristics);
	public void setNearbyBombs(FieldCell cell);
	public int countBomb(int counter);
	public void analyzeWorking(Characteristics characteristics);
		
	
		
	
}
