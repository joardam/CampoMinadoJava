package com.mygdx.gameField.cell;

public class SafeCell extends FieldCell{
	private int nearBombs;
	
	public void setNearBombs(int nearBombs) {
		this.nearBombs = nearBombs;
	}
	
	public int getNearBombs() {
		return this.nearBombs;
	}

}

