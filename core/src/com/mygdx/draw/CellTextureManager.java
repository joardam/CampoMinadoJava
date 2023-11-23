package com.mygdx.draw;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.cellProfile.MinedCell;
import com.mygdx.gameField.cell.cellProfile.SafeCell;
import com.mygdx.gameField.cell.state.*;


public class CellTextureManager {
	
	public static int getTextureByCell(FieldCell cellInCol) {
		if(cellInCol.getCellState() instanceof CoveredCellState) {
			
			if(cellInCol.getCellState() instanceof CoveredCellState && ((CoveredCellState)cellInCol.getCellState()).isFlagged()) {
				return 11;
			}
			
			
			
			return 10;
		}
		
		if(cellInCol.getCellState() instanceof UncoveredCellState) {
			if(cellInCol.getCellType() instanceof MinedCell) {
				return 9;
			}
			else if(cellInCol.getCellType() instanceof SafeCell) {
				final int nearBombsNumber = ((SafeCell) cellInCol.getCellType()).getNearBombs();
				return nearBombsNumber;
			}
		}
		
		return 0;
	}
	
}
