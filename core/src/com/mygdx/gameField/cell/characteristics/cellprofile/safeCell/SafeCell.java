package com.mygdx.gameField.cell.characteristics.cellprofile.safeCell;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.cellprofile.CellProfile;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public abstract class SafeCell extends CellProfile{

	@Override
	public void passRoundFilter(Characteristics characteristics, RoundPlayerManager roundManager) {
		characteristics.passRound(roundManager);
		return;
		
	}
	
}
