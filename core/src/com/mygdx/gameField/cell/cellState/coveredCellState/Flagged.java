package com.mygdx.gameField.cell.cellState.coveredCellState;

import com.mygdx.gameField.cell.FieldCell;

public class Flagged extends Covered{
	
	public void analyzeInWorking(FieldCell cell , String sideInteraction) {
		super.analyzeInWorking(cell, sideInteraction);
	}

	@Override
	public void analyzeStart(FieldCell cell) {
		return;
		
	}
	
}
