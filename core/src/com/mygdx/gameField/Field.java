package com.mygdx.gameField;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.NearCells;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCell;
import com.mygdx.utils.Coordinates;
import com.mygdx.utils.GameUtils;

public abstract class Field implements FieldInterface{
	protected FieldCell[][] cells;
	protected int coveredCellsNumber;
	protected int bombsQuantity;
	
	
	
	
	public void placeNearCellInEachCell(){
		
		  for (int arrayPosX = 0; arrayPosX < cells.length; arrayPosX++) {
			  for (int arrayPosY = 0; arrayPosY < cells[arrayPosX].length; arrayPosY++) {
		        		
				  	int counter = 0; 
		        	for(int i = +1 ; i >=  -1  ; i--) {
		        		for(int k = -1 ; k <= +1 ; k++) {
		        			
		        			if(i == 0 && k == 0) {
		        				continue;
		        			}
		        			
		        			
		       
		        			if(GameUtils.isIn2DArrayBound(new Coordinates(arrayPosX + k,arrayPosY + i), cells.length, cells[arrayPosX].length)) {
		        				
		        				cells[arrayPosX][arrayPosY].getNearCells().getNearCellsArray()[counter] = cells[arrayPosX + k][arrayPosY  + i];
		        			
		        			}
		        			
		        			counter++;
		        			
		        		}
		        			
		        	}
		        	
		        	}
		        }
		
		
	}
	
	
	public void setBombsQuantity(int bombsQuantity) {
		this.bombsQuantity = bombsQuantity;
	}



	public void placeBombs(){


		for (int i = 0; i < (bombsQuantity); i++) {

			int bombX = GameUtils.randomBetween(0, cells.length - 1);
			int bombY = GameUtils.randomBetween(0, cells[0].length - 1);

			if (cells[bombX][bombY].getProfile() instanceof MinedCell) {
				i--;
				continue;
			}
			else {
				cells[bombX][bombY].setProfile(new MinedCell());
			
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

	            currentCell.getProfile().setNearbyBombs(currentCell);
	            
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

	            if (GameUtils.isIn2DArrayBound(loopX, loopY, cells.length, cells[0].length)) {
	                if (cells[loopX][loopY].getProfile() instanceof MinedCell) {
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
