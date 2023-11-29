package com.mygdx.draw;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.WarningSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.covered.Covered;
import com.mygdx.gameField.cell.characteristics.state.covered.CoveredOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.covered.flagged.Flagged;
import com.mygdx.gameField.cell.characteristics.state.covered.flagged.FlaggedOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.covered.notFlagged.NotFlaggedOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.uncovered.UncoveredOfClassicMode;


public class CellTextureManager {
	
	public static int getTextureByCell(FieldCell cellInCol) {
		if(cellInCol.getCellState() instanceof Covered) {
					
			if(cellInCol.getCharacteristics().getCoveredState() instanceof Flagged) {
				return 11;
			}
			
			
			return 10;
		}
		
		else if(cellInCol.getCellState() instanceof UncoveredOfClassicMode) {
			if(cellInCol.getProfile() instanceof MinedCell) {
				return 9;
			}
			else if(cellInCol.getProfile() instanceof WarningSafeCellOfClassicMode) {
				final int nearBombsNumber = ((WarningSafeCellOfClassicMode) cellInCol.getProfile()).getNearbyBombs();
				return nearBombsNumber;
			}
		}
		
		return 0;
	}
	
}
