package com.mygdx.gameField.cell.state;

public class CoveredCellState extends CellState {
	private boolean flagged = false;

	public boolean isFlagged() {
		return flagged;
	}

	public void toggleFlag() {
		this.flagged = !this.flagged;
	}
	
	
	
}
	
	
