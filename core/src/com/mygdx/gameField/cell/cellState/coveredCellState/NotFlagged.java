package com.mygdx.gameField.cell.cellState.coveredCellState;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.cellState.CellState;

public class NotFlagged extends Covered {
	
	private boolean flagged = false;

	public boolean isFlagged() {
		return flagged;
	}

	public void toggleFlag() {
		this.flagged = !this.flagged;
	}

	@Override
	public void analyzeStart(FieldCell cell) {
		//reveal
		cell.getCellType().analyzeStart(cell);
		
	}
	
	@Override
	public void analyzeInWorking(FieldCell cell, String sideInteraction) {
		super.analyzeInWorking(cell, sideInteraction);
	}

	

	
	
	
	
	
}
	
	
