package com.mygdx.gameField.cell.characteristics.cellprofile;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;

public class MinedCell extends CellProfile {

	@Override
	public void revealInteract(FieldCell cell) {
		
	}

	@Override
	public void flagInteract(FieldCell cell) {
		// TODO Auto-generated method stub
		
	}


	

	@Override
	public void setNearbyBombs(FieldCell cell) {
		return;
		
	}
	
	@Override
	public int countBomb(int counter) {
		counter++;
		return counter ;
		
	}

	@Override
	public void analyzeStart(Characteristics characteristics) {
		//explode 
		return;
		
	}

	@Override
	public void analyzeWorking(Characteristics characteristics) {
		return;
		
	}

	
}