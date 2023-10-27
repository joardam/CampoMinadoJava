package com.mygdx.draw;

import com.mygdx.gameField.cell.FieldCell; 
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
			if(cell instanceof MinedCell) {
				return 9;
			}
			else if(cell instanceof SafeCell) {
				final int nearBombsNumber = ((SafeCell) cell).getNearBombs();
				return nearBombsNumber;
			}
		}
		
		return 0;
	}
	
}
