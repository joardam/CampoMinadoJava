package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;

public class Flagged extends Covered{
	
	@Override
	public void analyzeStart(Characteristics characteristics) {
		return;
		
	}

	@Override
	public void analyzeWorking(Characteristics characteristics) {
		super.analyzeWorking(characteristics);
		
	}

	@Override
	public void interactFlag(Characteristics characteristics) {
		characteristics.setState(new NotFlagged());

		
		
		
	}

	
	
}
