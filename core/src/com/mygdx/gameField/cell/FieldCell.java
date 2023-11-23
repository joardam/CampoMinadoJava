package com.mygdx.gameField.cell;

import com.mygdx.gameField.cell.cellProfile.CellProfile;
import com.mygdx.gameField.cell.cellProfile.MinedCell;
import com.mygdx.gameField.cell.cellProfile.safeCell.CompleteSafeCell;
import com.mygdx.gameField.cell.cellProfile.safeCell.WarningSafeCell;
import com.mygdx.gameField.cell.cellState.CellState;
import com.mygdx.gameField.cell.cellState.Uncovered;
import com.mygdx.gameField.cell.cellState.coveredCellState.NotFlagged;
import com.mygdx.utils.Coordinates;

public abstract class FieldCell {
	
	
	private NearCells nearCells = new NearCells();
	
	
	public NearCells getNearCells() {
		return nearCells;
	}

	private Coordinates position;
	private CellState cellState = new NotFlagged();
	private CellProfile cellType = new CompleteSafeCell();

	
	
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
		this.cellState = new NotFlagged();
	}
	
	public void setCellProfileWarningSafeCell() {
		this.cellType = new WarningSafeCell();
	}
	
	public void toggleFlagState() {
		((NotFlagged) this.cellState).toggleFlag();
	}
	
	public void setCellStateUncovered() {
		this.cellState = new Uncovered();
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
