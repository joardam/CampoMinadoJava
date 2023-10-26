package com.mygdx.gameField.cell;

public class CellStructureManager {
	public static void UncoverCell(FieldCell cell) {
		if (cell.getBlockedToChangeState()) {}
		else {
			cell.setCellStateUncovered();
			}
	}
}
