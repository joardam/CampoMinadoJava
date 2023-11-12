package com.mygdx.gameField.cell;

import com.mygdx.gameField.cell.state.CoveredCellState;
import com.mygdx.gameField.cell.state.UncoveredCellState;

public class CellStructureManager {
	
	
	public static void UncoverCell(ClassicCell cell) {
		if (cell.getCellState() instanceof UncoveredCellState ||
			(cell.getCellState() instanceof CoveredCellState && ((CoveredCellState)cell.getCellState()).isFlagged())) {
		//do nothing
		}
		else {
			cell.setCellStateUncovered();
			}
	}
	
	public static void ToggleFlagCell(ClassicCell cell) {
		
		
		if(cell.getCellState() instanceof CoveredCellState) {
			if(cell.getCellState() instanceof CoveredCellState){
				cell.toggleFlagState();
			}
			
		}
	}
	
	public static void forceUncoverCell(FieldCell cells) {
		cells.setCellStateUncovered();
		
		
	}
	
	
	
}
