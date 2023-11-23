package com.mygdx.draw;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.cellProfile.MinedCell;
import com.mygdx.gameField.cell.cellProfile.safeCell.CompleteSafeCell;
import com.mygdx.gameField.cell.cellProfile.safeCell.WarningSafeCell;
import com.mygdx.gameField.cell.cellState.*;
import com.mygdx.gameField.cell.cellState.coveredCellState.NotFlagged;


public class CellTextureManager {
	
	public static int getTextureByCell(FieldCell cellInCol) {
		if(cellInCol.getCellState() instanceof NotFlagged) {
			
			if(cellInCol.getCellState() instanceof NotFlagged && ((NotFlagged)cellInCol.getCellState()).isFlagged()) {
				return 11;
			}
			
			
			
			return 10;
		}
		
		if(cellInCol.getCellState() instanceof Uncovered) {
			if(cellInCol.getCellType() instanceof MinedCell) {
				return 9;
			}
			else if(cellInCol.getCellType() instanceof WarningSafeCell) {
				final int nearBombsNumber = ((WarningSafeCell) cellInCol.getCellType()).getNearbyBombs();
				return nearBombsNumber;
			}
		}
		
		return 0;
	}
	
}
