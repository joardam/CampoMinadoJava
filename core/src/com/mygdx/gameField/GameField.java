package com.mygdx.gameField;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.MinedCell;
import com.mygdx.gameField.cell.SafeCell;
import com.mygdx.utils.Utils;

public class GameField  {
	private int rows;
	private int cols;
	private FieldCell[][] cells;
	
	public GameField(int rows , int cols) {
		this.rows = rows;
		this.cols = cols;
	}
	

	
	
	
	public void fillCells() {
	    cells = new FieldCell[rows - 2][cols - 2];

	    for (int arrayPosX = 0; arrayPosX < cells.length; arrayPosX++) {
	        for (int arrayPosY = 0; arrayPosY < cells[arrayPosX].length; arrayPosY++) {
	            int posX = arrayPosX + 1;
	            int posY = arrayPosY + 1;
	            cells[arrayPosX][arrayPosY] = new SafeCell(posX, posY);
	        }
	    }
	}

	
	public void placeBombs(){
		
		int apparentCellsRows = rows - 2;
		int apparentCellsCols = cols - 2;
		int bombsQuantity = 7;

		for (int i = 0; i < (bombsQuantity); i++) {

			int bombX = Utils.randomBetween(1, apparentCellsRows);
			int bombY = Utils.randomBetween(1, apparentCellsCols);

			if (cells[bombX - 1][bombY - 1] instanceof MinedCell) {
				i--;
				continue;
			}
			else {
				cells[bombX - 1][bombY - 1] = new MinedCell(bombX,bombY);
			
			};

		}
	}
	
	
	
	public void placeCountersInSafeCells() {
	    for (int i = 0; i < cells.length; i++) {
	        for (int j = 0; j < cells[i].length; j++) {
	            FieldCell currentCell = cells[i][j];

	            if (currentCell instanceof SafeCell) {
	                int bombCount = countNearbyBombs(i, j);
	                ((SafeCell) currentCell).setNearBombs(bombCount);
	            }
	        }
	    }
	}

	private int countNearbyBombs(int x, int y) {
	    int bombCount = 0;

	    for (int k = -1; k <= 1; k++) {
	        for (int l = -1; l <= 1; l++) {
	            if (k == 0 && l == 0) continue;

	            int loopX = x + k;
	            int loopY = y + l;

	            if (Utils.isIn2DArrayBound(loopX, loopY, cells.length, cells[0].length)) {
	                if (cells[loopX][loopY] instanceof MinedCell) {
	                    bombCount++;
	                }
	            }
	        }
	    }

	    return bombCount;
	}

	
	
	
	
	public FieldCell[][] getCells(){
		return this.cells;
	}
	
	public int getRows(){
		return this.rows;
	}
	
	public int getCols() {
		return this.cols;
	}
	
	
	
	
	
	
	
}
