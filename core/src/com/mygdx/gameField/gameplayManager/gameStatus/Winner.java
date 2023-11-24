package com.mygdx.gameField.gameplayManager.gameStatus;

import com.mygdx.gameField.gameplayManager.GameplayManager;

public class Winner extends GameStatus {

	public Winner(GameplayManager gameplayManager) {
		super(gameplayManager);
		
	}

	@Override
	public void declareLoss() {
		gameplayManager.declareLoss();
		
	}

	@Override
	public void declareWin() {
		return;
		
	}

}
