package com.mygdx.gameField.cell.State.Covered;

import com.mygdx.gameField.cell.State.CellState;

public class CoveredCellState extends CellState {
	private boolean blockedToUncover = false;
	
	public CoveredCellState() {
		
	}
	
	public void setBlockedToUncover(boolean blockedToUncover) {
		this.blockedToUncover = blockedToUncover;
	}
	
	public boolean getBlockedToUncover() {
		return this.blockedToUncover;
	}
	
	
}
