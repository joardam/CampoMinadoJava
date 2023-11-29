package com.mygdx.gameField.gameplayManager.gameStatus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.gameModeState.GameModeState;
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

	@Override
	public void interactLossStatus(GameModeState gameModeState, SpriteBatch sprite) {
		return;
		
	}

	@Override
	public void interactWinStatus(GameModeState gameModeState, SpriteBatch sprite) {
		gameModeState.drawWinCase(sprite);
		
	}

}
