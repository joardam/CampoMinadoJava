package com.mygdx.gameField.cell.characteristics.state;


import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public class Uncovered extends CoveredState {
	
	

	

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


	@Override
	public void analyzeStart(Characteristics characteristics, Field field) {
		return;
		
	}

	@Override
	public void analyzeWorking(Field field, Characteristics characteristics) {
		return;
		
	}

	

	

	

	

	
}
