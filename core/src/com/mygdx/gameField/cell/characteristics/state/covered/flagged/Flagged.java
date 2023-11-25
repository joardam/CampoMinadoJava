package com.mygdx.gameField.cell.characteristics.state.covered.flagged;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;
import com.mygdx.gameField.cell.characteristics.state.covered.Covered;

public abstract class Flagged extends Covered{

	@Override
	public void interactFlag(Characteristics characteristics) {
		characteristics.setFlagged();
		
	}
	
}
