package com.mygdx.draw;

import com.mygdx.gameField.cell.CrazyModeCell;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.cellType.MinedCell;
import com.mygdx.gameField.cell.cellType.SafeCell;
import com.mygdx.gameField.cell.state.*;


public class CellTextureManager {
	
	public static int getTextureByCell(FieldCell cellInCol) {
		if(cellInCol.getCellState() instanceof CoveredCellState) {
			
			if(cellInCol.getCellState() instanceof CoveredCellState && ((CoveredCellState)cellInCol.getCellState()).isFlagged()) {
				return 11;
			}
			
			if((cellInCol instanceof CrazyModeCell) && ((CrazyModeCell)cellInCol).isCrazyCell()) {
				return 12;
			}
			
			return 10;
		}
		
		if(cellInCol.getCellState() instanceof UncoveredCellState) {
			if(cellInCol.getCellType() instanceof MinedCell) {
				return 9;
			}
			else if(cellInCol.getCellType() instanceof SafeCell) {
				final int nearBombsNumber = cellInCol.getNearBombs();
				return nearBombsNumber;
			}
		}
		
		return 0;
	}
	
}
