package com.mygdx.gameField.cell.cellState;

import com.mygdx.gameField.cell.FieldCell;

public interface CellStateInterface {
	public void analyzeStart(FieldCell cell);
	public void analyzeInWorking(FieldCell cell , String sideInteraction);
	
}
