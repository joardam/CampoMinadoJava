package com.mygdx.gameField.cell.characteristics.state.uncovered;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;

public abstract class Uncovered extends CoveredState{

	@Override
	public void analyzeWorking(Characteristics characteristics) {
	}

	@Override
	public void interactFlag(Characteristics characteristics) {
		
	}

	@Override
	public int analyzeWin(int counter) {
		return 0;
	}

}
