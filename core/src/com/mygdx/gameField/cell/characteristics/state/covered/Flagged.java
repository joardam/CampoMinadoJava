package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

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
		characteristics.setCoveredState(new NotFlagged());

		
		
		
	}

	@Override
	public void roundPassFilter(Characteristics characteristics, RoundPlayerManager roundManager) {
		return;
		
	}

	@Override
	public int getCellTextureId(Characteristics characteristics) {
		return 11;
	}

	

	
	
}
