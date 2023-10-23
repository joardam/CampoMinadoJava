package com.mygdx.gameField;

public class GameField  {
	int rows;
	int cols;
	int[][] matrix ;
	int[][] sMatrix ;
	
	
	public GameField(int rows , int cols) {
		this.rows = rows;
		this.cols = cols;
		matrix = new int[this.rows][this.cols];
		sMatrix = new int[this.rows][this.cols];
	}
	
	

	

	public void fillMatrixes() {
		
		for (int row = 1; row <= rows - 2; row++) {
			for (int col = 1; col <= cols - 2; col++) {
				this.matrix[row][col] = 10;
			}
		}
		
		for (int row = 1; row <= rows - 2; row++) {
			for (int col = 1; col <= cols - 2; col++) {
				this.sMatrix[row][col] = 10;
			}
		}
	}
	
	public int[][] getMatrix(){
		return this.matrix;
	}
	
	
	
	
}
