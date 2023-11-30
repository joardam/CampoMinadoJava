package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public class Flagged extends Covered{
	
	


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

	@Override
	public void analyzeStart(Characteristics characteristics, Field field) {
		return;
		
	}

	@Override
	public void analyzeWorking(Field field, Characteristics characteristics) {
		characteristics.passToProfileAnalyzeWorking(field);
		
	}

	

	
	
}
