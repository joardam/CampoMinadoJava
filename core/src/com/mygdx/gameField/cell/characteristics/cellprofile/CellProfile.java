package com.mygdx.gameField.cell.characteristics.cellprofile;

import com.mygdx.gameField.cell.FieldCell;

public abstract class CellProfile implements CellProfileInterface{
	public int countBomb(int counter) {
		return counter;
	}
	
	@Override
	public void setNearbyBombs(FieldCell cell) {
		return;
		
	}


}
