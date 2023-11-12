package com.mygdx.draw;

import com.mygdx.gameField.cell.ClassicCell;
import com.mygdx.gameField.cell.cellType.MinedCell;
import com.mygdx.gameField.cell.cellType.SafeCell;
import com.mygdx.gameField.cell.state.*;


public class CellTextureManager {
	
	public static int getTextureByCell(ClassicCell cell) {
		if(cell.getCellState() instanceof CoveredCellState) {
			if(cell.getCellState() instanceof CoveredCellState && ((CoveredCellState)cell.getCellState()).isFlagged()) {
				return 11;
			}
			return 10;
		}
		
		if(cell.getCellState() instanceof UncoveredCellState) {
			if(cell.getCellType() instanceof MinedCell) {
				return 9;
			}
			else if(cell.getCellType() instanceof SafeCell) {
				final int nearBombsNumber = cell.getNearBombs();
				return nearBombsNumber;
			}
		}
		
		return 0;
	}
	
}
