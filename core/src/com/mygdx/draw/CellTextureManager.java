package com.mygdx.draw;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.WarningSafeCell;
import com.mygdx.gameField.cell.characteristics.state.Uncovered;
import com.mygdx.gameField.cell.characteristics.state.covered.Covered;
import com.mygdx.gameField.cell.characteristics.state.covered.Flagged;
import com.mygdx.gameField.cell.characteristics.state.covered.NotFlagged;


public class CellTextureManager {
	
	public static int getTextureByCell(FieldCell cellInCol) {
		if(cellInCol.getCellState() instanceof Covered) {
			
			if(cellInCol.getCellState() instanceof Flagged) {
				return 11;
			}
			
			
			return 10;
		}
		
		else if(cellInCol.getCellState() instanceof Uncovered) {
			if(cellInCol.getProfile() instanceof MinedCell) {
				return 9;
			}
			else if(cellInCol.getProfile() instanceof WarningSafeCell) {
				final int nearBombsNumber = ((WarningSafeCell) cellInCol.getProfile()).getNearbyBombs();
				return nearBombsNumber;
			}
		}
		
		return 0;
	}
	
}
