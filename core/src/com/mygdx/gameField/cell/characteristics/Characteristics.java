package com.mygdx.gameField.cell.characteristics;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.CellProfile;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.SafeCell;
import com.mygdx.gameField.cell.characteristics.state.CellState;
import com.mygdx.gameField.cell.characteristics.state.covered.NotFlagged;

public class Characteristics {
	private CellProfile profile = new CompleteSafeCell();
	private CellState state = new NotFlagged();
	private FieldCell cell;
	
	public Characteristics(FieldCell cell) {
		this.cell = cell;
	}
	
	public void startAnalyzeInteraction() {
		state.analyzeStart(this);
		
	}

	public void passToProfileAnalyzeStart() {
		profile.analyzeStart(this);
		
	}
	
	public void uncover() {
		cell.setCellStateUncovered();
		
	}
	
	
	public void analyzeWorking() {
		for(int i = 0;i <= 7 ; i++) {
			FieldCell cellNow = cell.getNearCells().getNearCellsArray()[i];
			
			if(!(cellNow == null)){
				passToStateAnalyzeWorking(cellNow);
			}
		}
	}

	public void passToStateAnalyzeWorking(FieldCell cellNow) {
				Characteristics characteristicsNow = cellNow.getCharacteristics();
				characteristicsNow.getState().analyzeWorking(characteristicsNow.returnThis());
	}				
				
	public void passToProfileAnalyzeWorking() {
		profile.analyzeWorking(this);
	}	
				
		
		

	public CellProfile getProfile() {
		return profile;
	}

	public void setProfile(CellProfile profile) {
		this.profile = profile;
	}

	public CellState getState() {
		return state;
	}

	public void setState(CellState state) {
		this.state = state;
	}
	
	public void setNotFlagged() {
		this.state = new NotFlagged();
	}
	
	
	public void interactFlag() {
	
		state.interactFlag(this);
		
	}
	

	
	public Characteristics returnThis() {
		return this;
	}
		
	}
	
	
