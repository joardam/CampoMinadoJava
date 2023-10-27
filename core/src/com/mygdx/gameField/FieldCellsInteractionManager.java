package com.mygdx.gameField;

import com.mygdx.gameField.cell.CellStructureManager;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.mouseTrack.MouseTrack;

public class FieldCellsInteractionManager {
	public static void tryToUncoverThisCell(MouseTrack mouse , GameField field){
		int posX = mouse.getMouseCordinates().getCoordinateX();
    	int posY  = mouse.getMouseCordinates().getCoordinateY();
    	
    	FieldCell cell = field.getCells()[posX - 1][posY - 1];
    	CellStructureManager.UncoverCell(cell);
	}
	
	public static void tryToToggleFlagThisCell(MouseTrack mouse , GameField field) {
		int posX = mouse.getMouseCordinates().getCoordinateX();
    	int posY  = mouse.getMouseCordinates().getCoordinateY();
    	
    	
    	FieldCell cell = field.getCells()[posX - 1][posY - 1];
    	CellStructureManager.ToggleFlagCell(cell);
	}
}
