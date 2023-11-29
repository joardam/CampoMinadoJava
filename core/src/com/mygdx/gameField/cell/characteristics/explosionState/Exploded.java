package com.mygdx.gameField.cell.characteristics.explosionState;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public class Exploded extends ExplosionState {

	@Override
	public void explosionChainWorking(Characteristics characteristics) {
		return;
		
	}

	@Override
	public void startExplodeChain(Characteristics characteristics) {
		return;
		
	}

	@Override
	public void analyzeLoss(GameStatus gameStatus) {
		gameStatus.declareLoss();
		
	}

}
