package com.mygdx.gameField.cell;

public class CrazyCell extends FieldCell {

	private boolean crazyCell = false;
	
	
	public CrazyCell() {
		super();
	}

	public CrazyCell(int x, int y) {
		super(x, y);
	}

	public boolean isCrazyCell() {
		return crazyCell;
	}

	public void setCrazyCell(boolean crazyCell) {
		this.crazyCell = crazyCell;
	}
	
	
	
	
	
	
}
