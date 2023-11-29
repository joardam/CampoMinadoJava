package com.mygdx.gameField.gameplayManager.gameStatus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.gameModeState.GameModeState;
import com.mygdx.gameField.gameplayManager.GameplayManager;

public abstract class GameStatus {
	protected GameplayManager gameplayManager;
	
	public GameStatus(GameplayManager gameplayManager){
		this.gameplayManager = gameplayManager;
	}
	
	
	
	public abstract void declareLoss();
	public abstract void declareWin();



	public abstract void interactWinStatus(GameModeState gameModeState, SpriteBatch sprite);
	public abstract void interactLossStatus(GameModeState gameModeState, SpriteBatch sprite);
}
