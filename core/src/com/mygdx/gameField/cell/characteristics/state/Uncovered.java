package com.mygdx.gameField.cell.characteristics.state;


import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public class Uncovered extends CoveredState {
	
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

	@Override
	public void roundPassFilter(Characteristics characteristics, RoundPlayerManager roundManager) {
		return;
		
	}

	@Override
	public int getCellTextureId(Characteristics characteristics) {
		return characteristics.passToPofileGetCellTextureId();
	}

	

	

	
}
