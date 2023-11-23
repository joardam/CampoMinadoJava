package com.mygdx.gameField.cell;

import com.mygdx.gameField.cell.cellProfile.CellProfile;
import com.mygdx.gameField.cell.cellProfile.MinedCell;
import com.mygdx.gameField.cell.cellProfile.SafeCell;
import com.mygdx.gameField.cell.state.CellState;
import com.mygdx.gameField.cell.state.CoveredCellState;
import com.mygdx.gameField.cell.state.UncoveredCellState;
import com.mygdx.utils.Coordinates;

public abstract class FieldCell {
	
	
	private NearCells nearCells;
	
	
	public NearCells getNearCells() {
		return nearCells;
	}

	private Coordinates position;
	private CellState cellState = new CoveredCellState();
	private CellProfile cellType = new SafeCell();

	
	
	public CellProfile getCellType() {
		return cellType;
	}

	public void setCellType(CellProfile cellType) {
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
	
	public void Bombfy() {
		this.cellType = new MinedCell();
	}
	
	
	public Coordinates getCellPosition() {
		return this.position;
	}
	
	
	
	public CellState getCellState() {
		return this.cellState;
	}
	
	
	
	
	
}
