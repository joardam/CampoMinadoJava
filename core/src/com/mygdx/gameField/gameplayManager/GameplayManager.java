package com.mygdx.gameField.gameplayManager;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.*;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.WarningSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.explosionState.Exploded;
import com.mygdx.gameField.cell.characteristics.state.covered.notFlagged.NotFlaggedOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.uncovered.UncoveredOfClassicMode;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;
import com.mygdx.gameField.gameplayManager.gameStatus.Looser;
import com.mygdx.gameField.gameplayManager.gameStatus.Playing;
import com.mygdx.gameField.gameplayManager.gameStatus.Winner;
import com.mygdx.utils.GameUtils;

public abstract class GameplayManager {
	
	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	
	protected GameStatus gameStatus = new Playing(this);
	
	
	 public void startTryToUncoverThisCell(int posX ,int posY, Field field) {
	        gameStatus.tryToUncoverThisCellFilter(posX ,posY,field);
	    }

	 
	public void tryToUncoverThisCell(int posX ,int posY, Field field) {
		 	FieldCell[][] cells = field.getCells();
	        FieldCell cell = cells[posX][posY];
	       
	        cell.getCharacteristics().startAnalyzeInteraction();
	        cell.analyzeLoss(gameStatus);
	        cell.analyzeWin(field, gameStatus);
	}
	
	
	 public void tryToToggleFlagThisCell(int posX,int posY, Field field) {
        FieldCell cell = field.getCells()[posX][posY];
        cell.interactFlag();
    }
    
	
	 
	
    
    //intern
    
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
