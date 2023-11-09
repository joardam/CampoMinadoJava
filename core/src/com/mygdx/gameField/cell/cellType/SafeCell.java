package com.mygdx.gameField.cell.cellType;



public class SafeCell extends CellType{
	
	public SafeCell() {
		
	}
	
	
	private int nearBombs;
	
	public void setNearBombs(int nearBombs) {
		this.nearBombs = nearBombs;
	}
	
	public int getNearBombs() {
		return this.nearBombs;
	}

}

