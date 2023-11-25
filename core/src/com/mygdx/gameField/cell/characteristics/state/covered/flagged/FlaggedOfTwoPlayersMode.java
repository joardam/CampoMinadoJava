package com.mygdx.gameField.cell.characteristics.state.covered.flagged;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.covered.CoveredOfTwoPlayersMode;

public class FlaggedOfTwoPlayersMode extends Flagged {

	@Override
	public void analyzeStart(Characteristics characteristics) {
		return;
		
	}
	
	@Override
	public void analyzeWorking(Characteristics characteristics) {
		
		
	}

	@Override
	public void interactFlag(Characteristics characteristics) {
		characteristics.setNotFlagged();
		
	}

	@Override
	public int analyzeWin(int counter) {
	
		return 0;
	}

}
