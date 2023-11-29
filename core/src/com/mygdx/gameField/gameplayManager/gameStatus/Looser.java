package com.mygdx.gameField.gameplayManager.gameStatus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.gameModeState.GameModeState;
import com.mygdx.gameField.gameplayManager.GameplayManager;
import com.mygdx.utils.InteractionManager;

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

	@Override
	public void winInEndlessInteraction(InteractionManager gamePointsInteraction, int gamePoints) {
		return;
		
	}

	@Override
	public void looseInEndlessInteraction(InteractionManager addNameInteraction) {
		if(!addNameInteraction.inAction()) {
			addNameInteraction.startInteraction();
		}
		
	}
	
	
}
