package com.mygdx.gameField.cell;

import com.mygdx.utils.Coordinates;

public class SafeCell extends FieldCell{
	
	
	public SafeCell() {
		
	}
	
	public SafeCell(Coordinates position) {
		super(position);
	}
	
	public SafeCell(int posX, int posY) {
		super.setPosition(posX, posY);;
	}

	
	
	private int nearBombs;
	
	public void setNearBombs(int nearBombs) {
		this.nearBombs = nearBombs;
	}
	
	public int getNearBombs() {
		return this.nearBombs;
	}

}

