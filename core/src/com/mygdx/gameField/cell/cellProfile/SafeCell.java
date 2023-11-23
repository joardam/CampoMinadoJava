package com.mygdx.gameField.cell.cellProfile;

import com.mygdx.gameField.cell.FieldCell;

public class SafeCell extends CellProfile{
	
	private int nearBombs;
	
	
	
	public SafeCell() {
		
	}

	@Override
	public void flagInteract(FieldCell cell) {
		
	}

	@Override
	public void revealInteract(FieldCell cell) {
		
		
		
		
		
		if (nearBombs > 0){
			return;
		}
		
		
		
		
		
		
	}
	
	public void analyze(FieldCell cell) {
		
	}
	
	public void setNearBombs(int nearBombs) {
		this.nearBombs = nearBombs;
	}
	
	public int getNearBombs() {
		return this.nearBombs;
	}
	

	 


}

