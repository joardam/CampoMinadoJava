package com.mygdx.gameField.gameplayManager;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.*;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.WarningSafeCell;
import com.mygdx.gameField.cell.characteristics.explosionState.Exploded;
import com.mygdx.gameField.cell.characteristics.state.Uncovered;
import com.mygdx.gameField.cell.characteristics.state.covered.NotFlagged;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;
import com.mygdx.gameField.gameplayManager.gameStatus.Looser;
import com.mygdx.gameField.gameplayManager.gameStatus.Playing;
import com.mygdx.gameField.gameplayManager.gameStatus.Winner;
import com.mygdx.utils.GameUtils;

public abstract class GameplayManager {
	protected boolean winStatus = false;
	protected boolean gameOverStatus = false;

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	protected GameStatus gameStatus = new Playing(this);
	

	public void tryToUncoverThisCell(int posX, int posY, Field field) {

		FieldCell[][] cells = field.getCells();
		FieldCell cell = cells[posX][posY];
		int count = 0;

		cell.getCharacteristics().startAnalyzeInteraction(field);
		cell.analyzeLoss(gameStatus);
		cell.analyzeWin(field, gameStatus);
		
		
		

	}

	public void tryToToggleFlagThisCell(int posX, int posY, Field field) {
		FieldCell cell = field.getCells()[posX][posY];
		cell.interactFlag();
	}

	

	public boolean getGameOverStatus() {
		return this.gameOverStatus;
	}

	public boolean isWinStatus() {
		return winStatus;
	}

	public void declareWin() {
		this.gameStatus = new Winner(this);
	}

	public void declareLoss() {
		this.gameStatus = new Looser(this);
	}

	public void restartGame() {
			this.gameStatus = new Playing(this); 
		
	}

}
