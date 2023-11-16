package com.mygdx.gameField;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.cellType.MinedCell;
import com.mygdx.gameField.cell.cellType.SafeCell;
import com.mygdx.utils.Utils;

public abstract class Field implements FieldInterface{
	protected FieldCell[][] cells;
	protected int coveredCellsNumber;
	protected int bombsQuantity;
	
	
	
	public void setBombsQuantity(int bombsQuantity) {
		this.bombsQuantity = bombsQuantity;
	}



	public void placeBombs(){


		for (int i = 0; i < (bombsQuantity); i++) {

			int bombX = Utils.randomBetween(0, cells.length - 1);
			int bombY = Utils.randomBetween(0, cells[0].length - 1);

			if (cells[bombX][bombY].getCellType() instanceof MinedCell) {
				i--;
				continue;
			}
			else {
				cells[bombX][bombY].setCellType(new MinedCell());
			
			};

		}
	}
	

	
	
	
	public int getCoveredCellsNumber() {
		return coveredCellsNumber;
	}


	public void decreaseCellsNumber(int cellsDiscovered) {
		this.coveredCellsNumber -= cellsDiscovered;
	}


	public void placeCountersInSafeCells() {
	    for (int i = 0; i < cells.length; i++) {
	        for (int j = 0; j < cells[i].length; j++) {
	            FieldCell currentCell = cells[i][j];

	            if (currentCell.getCellType() instanceof SafeCell) {
	                int bombCount = countNearbyBombs(i, j);
	                currentCell.setNearBombs(bombCount);
	            }
	        }
	    }
	}

	public int countNearbyBombs(int x, int y) {
	    int bombCount = 0;

	    for (int k = -1; k <= 1; k++) {
	        for (int l = -1; l <= 1; l++) {
	            if (k == 0 && l == 0) continue;

	            int loopX = x + k;
	            int loopY = y + l;

	            if (Utils.isIn2DArrayBound(loopX, loopY, cells.length, cells[0].length)) {
	                if (cells[loopX][loopY].getCellType() instanceof MinedCell) {
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


	public int getBombsQuantity() {
		return bombsQuantity;
	}
	
}
