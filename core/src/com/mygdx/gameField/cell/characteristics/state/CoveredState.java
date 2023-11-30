package com.mygdx.gameField.cell.characteristics.state;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public abstract class CoveredState implements CellStateInterface{
	public abstract void analyzeStart(Characteristics characteristics, Field field);
		

	public abstract void roundPassFilter(Characteristics characteristics, RoundPlayerManager roundManager);

	public abstract int getCellTextureId(Characteristics characteristics);


	public abstract void analyzeWorking(Field field, Characteristics characteristics);
	
	

	
	
}
