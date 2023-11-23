package com.mygdx.gameField.cell.cellState.coveredCellState;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.cellState.CellState;


public abstract class Covered extends CellState{
	@Override
	public void analyzeInWorking(FieldCell cell, String sideInteraction) {
		cell.getCellType().analyzeInWorking(cell, sideInteraction);
	}
}

