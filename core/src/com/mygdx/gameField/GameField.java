package com.mygdx.gameField;

import com.mygdx.gameField.cell.FieldCell;
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
		cells = new FieldCell[this.rows - 2][this.cols - 2];
		int arrayPosX = 0;
		int arrayPosY = 0;
		
		for(FieldCell[] cellsByCol: cells) {
			for(FieldCell cellInCol : cellsByCol) {
				int posX = arrayPosX + 1;
				int posY = arrayPosY + 1;
				
				cells[arrayPosX][arrayPosY] =  new FieldCell();
				cells[arrayPosX][arrayPosY].setPosition(posX, posY);
				arrayPosY++;
			}
		arrayPosY = 0;
		arrayPosX++;
		}
		
	}
	
	public void placeBombs(){
		
		int apparentCellsRows = rows - 2;
		int apparentCellsCols = cols - 2;
		int bombsQuantity = 6;

		for (int i = 0; i < (bombsQuantity); i++) {

			int bombX = Utils.randomBetween(1, apparentCellsRows) - 1;
			int bombY = Utils.randomBetween(1, apparentCellsCols) - 1;

			if (cells[bombX][bombY].getInnerTexture() == 9) {
				i--;
				continue;
			}
			else {
				cells[bombX][bombY].setInnerTexture(9);
			
			};

		}
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
