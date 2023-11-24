package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;

public class NotFlagged extends Covered {
	



	@Override
	public void analyzeStart(Characteristics characteristics) {
		characteristics.passToProfileAnalyzeStart();
		
		
	}
	
	@Override
	public void analyzeWorking(Characteristics characteristics) {
		super.analyzeWorking(characteristics);
	}

	@Override
	public void interactFlag(Characteristics characteristics) {
		characteristics.setCoveredState(new Flagged());
		
		
	}


	
	
}
	
	
