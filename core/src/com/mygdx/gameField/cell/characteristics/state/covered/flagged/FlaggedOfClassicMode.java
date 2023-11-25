package com.mygdx.gameField.cell.characteristics.state.covered.flagged;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.covered.CoveredOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.covered.notFlagged.NotFlaggedOfClassicMode;

public class FlaggedOfClassicMode extends Flagged{
	
	@Override
	public void analyzeStart(Characteristics characteristics) {
		return;
		
	}

	@Override
	public void analyzeWorking(Characteristics characteristics) {
		characteristics.passToProfileAnalyzeWorking();
		
	}

	@Override
	public void interactFlag(Characteristics characteristics) {
		characteristics.setNotFlagged();
		
		
		
	}

	@Override
	public int analyzeWin(int counter) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
