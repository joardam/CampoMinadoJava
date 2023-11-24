package com.mygdx.gameField.gameplayManager.gameStatus;

import com.mygdx.gameField.gameplayManager.GameplayManager;

public abstract class GameStatus {
	protected GameplayManager gameplayManager;
	
	public GameStatus(GameplayManager gameplayManager){
		this.gameplayManager = gameplayManager;
	}
	
	
	
	public abstract void declareLoss();
	public abstract void declareWin();
}
