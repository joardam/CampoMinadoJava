package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;

public abstract class Covered extends CoveredState{

public abstract class Covered extends CoveredState{
	@Override
	public void analyzeWorking(Characteristics characteristics) {
		characteristics.passToProfileAnalyzeWorking();
	}
	
	@Override
	public int analyzeWin(int counter) {
		counter++;
		return counter;
	}

}

