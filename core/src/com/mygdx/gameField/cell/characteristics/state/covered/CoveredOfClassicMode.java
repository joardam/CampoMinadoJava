package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;
import com.mygdx.gameField.gameplayManager.GameplayManager;
import com.mygdx.gameField.gameplayManager.Mode2PlayersManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;


public abstract class CoveredOfClassicMode extends Covered{
	@Override
	public void analyzeWorking(Characteristics characteristics) {
		characteristics.passToProfileAnalyzeWorking();
	}
	
	@Override
	public int analyzeWin(int counter) {
		counter++;
		return counter;
	}


	
	


	
	
	
}

