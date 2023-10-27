package com.mygdx.gameField.cell;

import com.mygdx.gameField.cell.state.UncoveredCellState;
import com.mygdx.gameField.cell.state.covered.CoveredCellAndFlaggedState;
import com.mygdx.gameField.cell.state.covered.*;

public class CellStructureManager {
	public static void UncoverCell(FieldCell cell) {
		if (cell.getCellState() instanceof UncoveredCellState ||
			cell.getCellState() instanceof CoveredCellAndFlaggedState) {
		//do nothing
		}
		else {
			cell.setCellStateUncovered();
			}
	}
	
	public static void ToggleFlagCell(FieldCell cell) {
		
		
		if(cell.getCellState() instanceof CoveredCellState) {
			if(cell.getCellState() instanceof CoveredCellAndFlaggedState){
				cell.setCellStateCovered();
			}
			else {
				cell.setCellStateCoveredAndFlagged();
			}
		}
	}
	
	public static void forceUncoverCell(FieldCell cell) {
		cell.setCellStateUncovered();
	}
	
}
