package com.mygdx.gameField.cell.characteristics.state.uncovered;


import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;

public class UncoveredOfClassicMode extends Uncovered {
	
	@Override
	public void analyzeStart(Characteristics characteristics) {
		super.analyzeStart(characteristics);
	}

	@Override
	public void analyzeWorking(Characteristics characteristics) {
		return;
		
	}

	@Override
	public void interactFlag(Characteristics characteristics) {
		return;
		
	}

	@Override
	public int analyzeWin(int counter) {
		return counter;
		
	}

	

	
}
