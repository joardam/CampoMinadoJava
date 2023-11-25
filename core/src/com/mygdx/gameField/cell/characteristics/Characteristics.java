package com.mygdx.gameField.cell.characteristics;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.CellProfile;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.SafeCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.WarningSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.explosionState.Exploded;
import com.mygdx.gameField.cell.characteristics.explosionState.ExplosionState;
import com.mygdx.gameField.cell.characteristics.explosionState.NotExploded;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;
import com.mygdx.gameField.cell.characteristics.state.covered.flagged.FlaggedOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.covered.flagged.FlaggedOfTwoPlayersMode;
import com.mygdx.gameField.cell.characteristics.state.covered.notFlagged.NotFlaggedOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.uncovered.UncoveredOfClassicMode;
import com.mygdx.gameField.gameplayManager.GameplayManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public abstract class Characteristics {
	protected CellProfile profile;
	protected CoveredState coveredState;
	protected ExplosionState explosionState = new NotExploded();
	
	
	protected FieldCell cell;
	
	public Characteristics(FieldCell cell) {
		this.cell = cell;
	}
	
	public void startAnalyzeInteraction() {
		coveredState.analyzeStart(this);
		
	}

	public void passToProfileAnalyzeStart() {
		profile.analyzeStart(this);
		
	}
	
	public abstract void uncover();
	
	
	public void startExplosionChain() {
		explosionState.startExplodeChain(this);
	}
	
	
	public void explosionChainWorking() {
		for(int i = 0;i <= 7 ; i++) {
			FieldCell cellNow = cell.getNearCells().getNearCellsArray()[i];
			
			if(!(cellNow == null)){
				passToExplosionStateExplosionChainWorking(cellNow);
			}
		}
	}
	
	
	public void passToExplosionStateExplosionChainWorking(FieldCell cellNow) {
		Characteristics characteristicsNow = cellNow.getCharacteristics();

		characteristicsNow.getExplosionState().explosionChainWorking(characteristicsNow);;
	}
	
	
	
	public void analyzeWorking() {
		for(int i = 0;i <= 7 ; i++) {
			FieldCell cellNow = cell.getNearCells().getNearCellsArray()[i];
			
			if(!(cellNow == null)){
				passToCoveredStateAnalyzeWorking(cellNow);
			}
		}
	}
	

	public void passToCoveredStateAnalyzeWorking(FieldCell cellNow) {
				Characteristics characteristicsNow = cellNow.getCharacteristics();
				characteristicsNow.getCoveredState().analyzeWorking(characteristicsNow.returnThis());
	}				
				
	public void passToProfileAnalyzeWorking() {
		profile.analyzeWorking(this);
	}	
				
		
		

	public ExplosionState getExplosionState() {
		return explosionState;
	}

	public CellProfile getProfile() {
		return profile;
	}

	public void setProfile(CellProfile profile) {
		this.profile = profile;
	}
	
	public void setMinedCell() {
		this.profile = new MinedCell();
		
	}
	public void setCompleteSafeCell() {
		this.profile = new CompleteSafeCellOfClassicMode();
	}
	
	public void setWarningSafeCell() {
		this.profile = new WarningSafeCellOfClassicMode();
	}
	
	public void setUncovered() {
		this.coveredState = new UncoveredOfClassicMode();
	}

	public CoveredState getCoveredState() {
		return coveredState;
	}

	public void setCoveredState(CoveredState state) {
		this.coveredState = state;
	}
	
	public void setExploded() {
		this.explosionState = new Exploded();
	}
	
	
	public void setNotFlagged() {
		this.coveredState = new NotFlaggedOfClassicMode();
	}
	
	public void setFlagged() {
		this.coveredState = new FlaggedOfClassicMode();
	}
	
	
	public void interactFlag() {
		coveredState.interactFlag(this);
	}
	
	public void analyzeLoss(GameStatus gameStatus) {
		explosionState.analyzeLoss(gameStatus);
	}
	
	
	public void analyzeWin(Field field , GameStatus gameStatus) {
		int counter = 0;
		int bombsQuantity = field.getBombsQuantity();
		FieldCell[][] cells = field.getCells();	
		
		  for (int arrayPosX = 0; arrayPosX < cells.length; arrayPosX++) {
			  for (int arrayPosY = 0; arrayPosY < cells[arrayPosX].length; arrayPosY++) {
				  FieldCell cellNow = cells[arrayPosX][arrayPosY];
				  Characteristics characteristicsNow = cellNow.getCharacteristics();
				  
				  counter = characteristicsNow.coveredState.analyzeWin(counter);
			  }
		  }
		  
		  
		  if(counter == bombsQuantity) {
			  gameStatus.declareWin();
			  startExplosionChain();
		  }
		
		
		
	}

	
	public Characteristics returnThis() {
		return this;
	}

	public void passPlayerIndexFilter(GameplayManager gameplayManager) {
		coveredState.passPlayerIndexFilter(gameplayManager);
		
	}
		
	}


	
	
