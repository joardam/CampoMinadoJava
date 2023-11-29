package com.mygdx.gameField;

import com.mygdx.gameField.cell.ClassicCell;


public class ClassicField  extends Field{
	
	
	public void fillCells(int cols, int rows) {
		 cells = new ClassicCell[cols][rows];
		    
		    for (int arrayPosX = 0; arrayPosX < cells.length; arrayPosX++) {
		        for (int arrayPosY = 0; arrayPosY < cells[arrayPosX].length; arrayPosY++) {
		            int posX = arrayPosX;
		            int posY = arrayPosY;
		            cells[posX][posY] = new ClassicCell(posX,posY);
		        }
		    }
		    coveredCellsNumber = (cells.length) * (cells[0].length);
	}

	
	
	
	
}
