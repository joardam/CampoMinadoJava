package com.mygdx.gameField.cell;

public class NearCells{
	
	    private FieldCell[] nearCells = new FieldCell[8];

	    public void setNearCells(FieldCell[] nearCells) {
	        this.nearCells = nearCells;
	    }

	    public FieldCell getTopLeftCell() {
	        return nearCells[0];
	    }

	    public void setTopLeftCell(FieldCell cell) {
	        nearCells[0] = cell;
	    }

	    public FieldCell getTopCenterCell() {
	        return nearCells[1];
	    }

	    public void setTopCenterCell(FieldCell cell) {
	        nearCells[1] = cell;
	    }

	    public FieldCell getTopRightCell() {
	        return nearCells[2];
	    }

	    public void setTopRightCell(FieldCell cell) {
	        nearCells[2] = cell;
	    }

	    public FieldCell getMiddleLeftCell() {
	        return nearCells[3];
	    }

	    public void setMiddleLeftCell(FieldCell cell) {
	        nearCells[3] = cell;
	    }

	    public FieldCell getMiddleRightCell() {
	        return nearCells[4];
	    }

	    public void setMiddleRightCell(FieldCell cell) {
	        nearCells[4] = cell;
	    }

	    public FieldCell getBottomLeftCell() {
	        return nearCells[5];
	    }

	    public void setBottomLeftCell(FieldCell cell) {
	        nearCells[5] = cell;
	    }

	    public FieldCell getBottomCenterCell() {
	        return nearCells[6];
	    }

	    public void setBottomCenterCell(FieldCell cell) {
	        nearCells[6] = cell;
	    }

	    public FieldCell getBottomRightCell() {
	        return nearCells[7];
	    }

	    public void setBottomRightCell(FieldCell cell) {
	        nearCells[7] = cell;
	    }
	}

	


