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
		return cellInCol.getCellTextureId();
	}
	
}
