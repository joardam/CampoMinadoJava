package com.mygdx.gameField.cell.characteristics.cellprofile;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public abstract class CellProfile implements CellProfileInterface{
	public int countBomb(int counter) {
		return counter;
	}
	
	@Override
	public abstract void setNearbyBombs(FieldCell cell) ;
	public abstract void passRoundFilter(Characteristics characteristics, RoundPlayerManager roundManager);
	public abstract int getCellTextureId();
	public abstract void analyzeStart(Characteristics characteristics, Field field);
	public abstract void analyzeWorking(Characteristics characteristics, Field field);
	public abstract void resetNearbyBombs(FieldCell cell) ;


}
