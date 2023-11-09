package com.mygdx.draw;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.cellType.MinedCell;
import com.mygdx.gameField.cell.cellType.SafeCell;
import com.mygdx.gameField.cell.*;
import com.mygdx.gameField.cell.state.*;
import com.mygdx.gameField.cell.state.covered.*;

public class CellTextureManager {
	
	public static int getTextureByCell(FieldCell cell) {
		if(cell.getCellState() instanceof CoveredCellState) {
			if(cell.getCellState() instanceof CoveredCellAndFlaggedState) {
				return 11;
			}
			return 10;
		}
		
		if(cell.getCellState() instanceof UncoveredCellState) {
			if(cell.getCellType() instanceof MinedCell) {
				return 9;
			}
			else if(cell.getCellType() instanceof SafeCell) {
				final int nearBombsNumber = ((SafeCell) cell.getCellType()).getNearBombs();
				return nearBombsNumber;
			}
		}
		
		return 0;
	}
	
}
