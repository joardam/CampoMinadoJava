package com.mygdx.gameField.cell;
import com.mygdx.gameField.cell.state.*;
import com.mygdx.gameField.cell.state.covered.CoveredCellAndFlaggedState;
import com.mygdx.gameField.cell.state.covered.CoveredCellState;
import com.mygdx.utils.Coordinates;



public class FieldCell {
	private Coordinates position;
	private CellState cellState = new CoveredCellState();
	
	
	public FieldCell() {
		
	}
	
	public FieldCell(Coordinates position) {
		this.position = position;
	
	}
	
	
	public void setPosition(int x ,int y){
		this.position = new Coordinates(x,y);
	}

	
	public void setCellStateCovered() {
		this.cellState = new CoveredCellState();
	}
	
	public void setCellStateCoveredAndFlagged() {
		this.cellState = new CoveredCellAndFlaggedState();
		
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
	
	
	
	
	
}
