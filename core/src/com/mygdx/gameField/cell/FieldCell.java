package com.mygdx.gameField.cell;

import com.mygdx.gameField.cell.cellType.CellType;
import com.mygdx.gameField.cell.cellType.SafeCell;
import com.mygdx.gameField.cell.state.CellState;
import com.mygdx.gameField.cell.state.CoveredCellState;
import com.mygdx.gameField.cell.state.UncoveredCellState;
import com.mygdx.utils.Coordinates;

public abstract class FieldCell {
	private Coordinates position;
	private CellState cellState = new CoveredCellState();
	private CellType cellType = new SafeCell();
	private int nearBombs;
	
	
	
	public CellType getCellType() {
		return cellType;
	}

	public void setCellType(CellType cellType) {
		this.cellType = cellType;
	}

	public FieldCell() {
		
	}
	
	public FieldCell(int x , int y) {
		this.position = new Coordinates(x,y);
	
	}
	
	
	public void setPosition(int x ,int y){
		this.position = new Coordinates(x,y);
	}

	
	public void setCellStateCovered() {
		this.cellState = new CoveredCellState();
	}
	
	public void toggleFlagState() {
		((CoveredCellState) this.cellState).toggleFlag();
	}
	
	public void setCellStateUncovered() {
		this.cellState = new UncoveredCellState();
	}
	
	
	public Coordinates getCellPosition() {
		return this.position;
	}
	
	
	
	public CellState getCellState() {
		return this.cellState;
	}
	
	
	public void setNearBombs(int nearBombs) {
		this.nearBombs = nearBombs;
	}
	
	public int getNearBombs() {
		return this.nearBombs;
	}
	
	
	
}
