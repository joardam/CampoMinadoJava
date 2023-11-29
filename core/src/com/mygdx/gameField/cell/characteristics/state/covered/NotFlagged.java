package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public class NotFlagged extends Covered {
	



	@Override
	public void analyzeStart(Characteristics characteristics) {
		characteristics.passToProfileAnalyzeStart();
		
		
	}
	
	@Override
	public void analyzeWorking(Characteristics characteristics) {
		super.analyzeWorking(characteristics);
	}

	@Override
	public void interactFlag(Characteristics characteristics) {
		characteristics.setCoveredState(new Flagged());
		
		
	}

	@Override
	public void roundPassFilter(Characteristics characteristics, RoundPlayerManager roundManager) {
		characteristics.passToProfileRoundPassFilter(roundManager);
		
	}

	@Override
	public int getCellTextureId(Characteristics characteristics) {
		return 10;
	}

	


	
	
}
	
	
