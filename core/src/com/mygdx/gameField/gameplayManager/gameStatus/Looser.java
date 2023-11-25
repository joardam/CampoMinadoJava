package com.mygdx.gameField.gameplayManager.gameStatus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.gameModeState.GameModeState;
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

	@Override
	public void interactLossStatus(GameModeState gameModeState, SpriteBatch sprite) {
		gameModeState.drawLossCase(sprite);
		
	}

	@Override
	public void interactWinStatus(GameModeState gamemodeState, SpriteBatch sprite) {
		return;
		
	}

}
