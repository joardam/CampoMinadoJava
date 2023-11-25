package com.mygdx.gameField.cell;

public class CrazyModeCell extends FieldCell {

	private boolean crazyCell = false;
	private boolean activated = false;
	

	public CrazyModeCell(int x, int y) {
		super(x, y);
	}

	public boolean isCrazyCell() {
		return crazyCell;
	}

	public void setCrazyCell(boolean crazyCell) {
		this.crazyCell = crazyCell;
	}

	public void activate() {
		this.activated = true;
	}

	public boolean isActivated() {
		return activated;
	}
	
	
		
		
	

}
