package com.mygdx.gameField.gameplayManager.gameStatus;

import com.mygdx.gameField.gameplayManager.GameplayManager;

public class Looser extends GameStatus {

	public Looser(GameplayManager gameplayManager) {
		super(gameplayManager);
		
	}

	@Override
	public void declareLoss() {
		return;
		
	}

	@Override
	public void declareWin() {
		gameplayManager.declareWin();
	}

}
