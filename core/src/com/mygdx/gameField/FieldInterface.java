package com.mygdx.gameField;

import com.mygdx.gameField.cell.FieldCell;

public interface FieldInterface {
	
	public void fillCells(int cols, int rowsS);
	public void placeBombs();
	public void placeCountersInSafeCells();
	public int countNearbyBombs(int x, int y);
	public FieldCell[][] getCells();

	
}
