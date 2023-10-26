package com.mygdx.gameField.cell;
import com.mygdx.gameField.cell.State.CellState;
import com.mygdx.gameField.cell.State.*;
import com.mygdx.gameField.cell.State.Covered.CoveredCellState;



public class FieldCell {
	private CellPosition position;
	private CellState cellState = new CoveredCellState();
	private boolean blockedToChangeState = false;
	
	
	public FieldCell() {
		
	}
	
	public FieldCell(CellPosition position) {
		this.position = position;
	
	}
	
	
	public void setPosition(int x ,int y){
		this.position = new CellPosition(x,y);
	}

	
	public void setCellStateCovered() {
		this.cellState = new CoveredCellState();
	}
	
	public void setCellStateUncovered() {
		this.cellState = new UncoveredCellState();
		this.blockedToChangeState = true;
	}
	
	public boolean getBlockedToChangeState() {
		return this.blockedToChangeState;
	}
	
	public CellPosition getCellPosition() {
		return this.position;
	}
	
	
	
	public CellState getCellState() {
		return this.cellState;
	}
	
	
	
	public class CellPosition {
		private int x;
		private int y;
		
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
