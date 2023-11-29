package com.mygdx.gameField.cell.characteristics.state;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public abstract class CoveredState implements CellStateInterface{
	public void analyzeStart(Characteristics characteristics) {
		return;
	}

	public abstract void roundPassFilter(Characteristics characteristics, RoundPlayerManager roundManager);

	public abstract int getCellTextureId(Characteristics characteristics);
	
	

	
	
}
