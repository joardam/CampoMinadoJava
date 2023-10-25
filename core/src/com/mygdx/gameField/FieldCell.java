package com.mygdx.gameField;

public class FieldCell {
	private CellPosition position;
	private int innerTexture = 0;
	private boolean coveredStatus = true;
	private boolean flagStatus = false;
	
	
	public FieldCell() {
		
	}
	
	public FieldCell(CellPosition position, int innerTexture) {
		this.position = position;
		this.innerTexture = innerTexture;
		
	}
	
	
	public void setPosition(int x ,int y){
		this.position = new CellPosition(x,y);
	}

	public void setFlagStatus(boolean flagStatus){
		this.flagStatus = flagStatus;
		
	}
	
	public void setInnerTexture(int innerTexture) {
		this.innerTexture = innerTexture;
	}
	
	public CellPosition getCellPosition() {
		return this.position;
	}
	
	public int getInnerTexture() {
		return this.innerTexture;
	}
	
	public boolean getCoveredStatus() {
		return this.coveredStatus;
	}
	
	public boolean getFlagStatus() {
		return this.flagStatus;
	}
	
	
	
	
	public class CellPosition {
		int x;
		int y;
		
		public CellPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getPosX() {
			return this.x;
		}
		public int getPosY() {
			return this.y;
		}
		
	}
	
}
