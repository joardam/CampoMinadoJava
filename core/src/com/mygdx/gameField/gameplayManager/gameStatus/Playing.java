package com.mygdx.gameField.gameplayManager.gameStatus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.gameModeState.GameModeState;
import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.gameplayManager.GameplayManager;
import com.mygdx.gameField.gameplayManager.Mode2PlayersManager;

public class Playing extends GameStatus {

	public Playing(GameplayManager gameplayManager) {
		super(gameplayManager);
		
	}

	@Override
	public void declareLoss() {
		gameplayManager.declareLoss();

	}

	@Override
	public void declareWin() {
		gameplayManager.declareWin();

	}

	@Override
	public void interactLossStatus(GameModeState gameModeState, SpriteBatch sprite) {
		return;
	}

	@Override
	public void interactWinStatus(GameModeState gameModeState, SpriteBatch sprite) {
		return;

	}
	
	public void tryToUncoverThisCellFilter(int posX, int posY, Field field) {
		gameplayManager.tryToUncoverThisCell(posX, posY, field);
	}

	@Override
	public void passPlayerIndexFilter(FieldCell cell) {
		cell.passPlayerIndexFilter(gameplayManager);
	}
	
	

}
