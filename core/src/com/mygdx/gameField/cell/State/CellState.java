package com.mygdx.gameField.cell.state;

public abstract class CellState {
	protected boolean isCrazy = false;

	public boolean isCrazy() {
		return isCrazy;
	}

	public void setCrazy(boolean isCrazy) {
		this.isCrazy = isCrazy;
	}
	
}
