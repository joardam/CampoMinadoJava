package com.mygdx.gameField;

import com.mygdx.gameField.cell.*;
import com.mygdx.utils.Utils;

public class CrazyField extends Field{
	private int crazyCellsQuantity = 10;
	
	@Override
	public void fillCells(int cols, int rows) {
	    cells = new CrazyModeCell[cols][rows];
	    
	    for (int arrayPosX = 0; arrayPosX < cells.length; arrayPosX++) {
	        for (int arrayPosY = 0; arrayPosY < cells[arrayPosX].length; arrayPosY++) {
	            int posX = arrayPosX;
	            int posY = arrayPosY;
	            cells[posX][posY] = new CrazyModeCell(posX,posY);
	            
	        }
	    }
	    coveredCellsNumber = (cells.length) * (cells[0].length);
	}
	
	
	
	public void placeCrazyness() {
		for (int i = 0; i < (crazyCellsQuantity); i++) {

			int crazyX = Utils.randomBetween(0, cells.length - 1);
			int crazyY = Utils.randomBetween(0, cells[0].length - 1);

			if (((CrazyModeCell)cells[crazyX][crazyY]).isCrazyCell()) {
				i--;
				continue;
			}
			else {
				((CrazyModeCell)cells[crazyX][crazyY]).setCrazyCell(true);
			
			};

		}
	}
	
	public void decreaseBombsQuantity() {
		this.bombsQuantity--;
	}
	public void increaseBombsQuantity() {
		this.bombsQuantity++;
	}
	
}
