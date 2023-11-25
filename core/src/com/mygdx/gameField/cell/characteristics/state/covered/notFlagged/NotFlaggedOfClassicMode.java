package com.mygdx.gameField.cell.characteristics.state.covered.notFlagged;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.covered.flagged.FlaggedOfClassicMode;
import com.mygdx.gameField.gameplayManager.GameplayManager;
import com.mygdx.gameField.gameplayManager.Mode2PlayersManager;

public class NotFlaggedOfClassicMode extends NotFlagged {


	@Override
	public void analyzeStart(Characteristics characteristics) {
		characteristics.passToProfileAnalyzeStart();
		
		
	}
	
	@Override
	public void analyzeWorking(Characteristics characteristics) {
		characteristics.passToProfileAnalyzeWorking();
	}

	@Override
	public void interactFlag(Characteristics characteristics) {
		characteristics.setFlagged();
	}

	@Override
	public void passPlayerIndexFilter(GameplayManager gameplayManager) {
		((Mode2PlayersManager)gameplayManager).passPlayerIndex();
	}

	@Override
	public int analyzeWin(int counter) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

	
	
}
	
	
