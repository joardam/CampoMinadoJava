package com.mygdx.gameField.cell.characteristics;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.CellProfile;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.SafeCell;
import com.mygdx.gameField.cell.characteristics.explosionState.Exploded;
import com.mygdx.gameField.cell.characteristics.explosionState.ExplosionState;
import com.mygdx.gameField.cell.characteristics.explosionState.NotExploded;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;
import com.mygdx.gameField.cell.characteristics.state.covered.NotFlagged;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;
import com.mygdx.utils.GameUtils;

public class Characteristics implements CharacteristicsOfTwoPlayersModeInterface{
	private CellProfile profile = new CompleteSafeCell();
	private CoveredState coveredState = new NotFlagged();
	private ExplosionState explosionState = new NotExploded();
	
	
	private FieldCell cell;
	
	public Characteristics(FieldCell cell) {
		this.cell = cell;
	}
	
	public void startAnalyzeInteraction(Field field) {
		coveredState.analyzeStart(this,field);
		
	}

	public void passToProfileAnalyzeStart(Field field) {
		profile.analyzeStart(this , field);
		
	}
	
	public void uncover() {
		cell.setCellStateUncovered();
		
	}
	
	
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
	
	
	
	public void analyzeWorking(Field field) {
		FieldCell[][] cells = field.getCells();
		
		
		int posX = cell.getCellPosition().getCoordinateX();
		int posY = cell.getCellPosition().getCoordinateY();
		
		for(int i = -1 ; i <= +1 ; i++) {
			for(int j = -1 ; j <= +1 ; j++) {
				
				if(GameUtils.isIn2DArrayBound(posX + i, posY + j, cells.length, cells[0].length)) {
					passToCoveredStateAnalyzeWorking(field , cells[posX + i][posY + j] , this);
				}
			}
			
		}
		
		
	}
	

	public void passToCoveredStateAnalyzeWorking(Field field, FieldCell cellNow, Characteristics characteristics) {
				Characteristics characteristicsNow = cellNow.getCharacteristics();
				characteristicsNow.getCoveredState().analyzeWorking(field, characteristicsNow.returnThis());
	}				
				
	public void passToProfileAnalyzeWorking(Field field) {
		profile.analyzeWorking(this , field);
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
		this.coveredState = new NotFlagged();
	}
	
	
	public void interactFlag() {
	
		coveredState.interactFlag(this);
		
	}
	
	public void analyzeLoss(GameStatus gameStatus) {
		explosionState.analyzeLoss(gameStatus);
	}
	

	
	public Characteristics returnThis() {
		return this;
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

	@Override
	public void roundPassFilter(RoundPlayerManager roundManager) {
		coveredState.roundPassFilter(this,roundManager);
		
	}

	public void passToProfileRoundPassFilter(RoundPlayerManager roundManager) {
		profile.passRoundFilter(this,roundManager);
	}

	
	public void passRound(RoundPlayerManager roundManager) {
			roundManager.passPlayerIndex();
		
	}

	public int getCellTextureId() {
		return coveredState.getCellTextureId(this);
	}

	public int passToPofileGetCellTextureId() {
		return profile.getCellTextureId();
	}
		
	}


	
	
