package com.mygdx.gameField.cell;

public class SafeCell extends FieldCell{
	
	public SafeCell() {
		
	}
	
	public SafeCell(CellPosition position) {
		super(position);
	}

	private int nearBombs;
	
	public void setNearBombs(int nearBombs) {
		this.nearBombs = nearBombs;
	}
	
	public int getNearBombs() {
		return this.nearBombs;
	}

}

