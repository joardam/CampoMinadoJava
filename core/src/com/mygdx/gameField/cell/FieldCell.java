package com.mygdx.gameField.cell;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.cellprofile.CellProfile;
import com.mygdx.gameField.cell.characteristics.cellprofile.MinedCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.WarningSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;
import com.mygdx.gameField.cell.characteristics.state.covered.notFlagged.NotFlagged;
import com.mygdx.gameField.cell.characteristics.state.covered.notFlagged.NotFlaggedOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.uncovered.UncoveredOfClassicMode;
import com.mygdx.gameField.gameplayManager.GameplayManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;
import com.mygdx.utils.Coordinates;

public abstract class FieldCell {

	private NearCells nearCells = new NearCells();
	protected Characteristics characteristics;
	private Coordinates position;

	public NearCells getNearCells() {
		return nearCells;
	}

	public Characteristics getCharacteristics() {
		return characteristics;
	}

	public CellProfile getProfile() {
		return characteristics.getProfile();
	}

	public void setProfile(CellProfile cellProfile) {
		this.characteristics.setProfile(cellProfile);
	}

	public FieldCell(int x, int y) {
		this.position = new Coordinates(x, y);

	}

	public void setPosition(int x, int y) {
		this.position = new Coordinates(x, y);
	}

	public void setCellStateCovered() {
		this.characteristics.setCoveredState(new NotFlaggedOfClassicMode());
	}

	public void setCellProfileWarningSafeCell() {
		this.characteristics.setProfile(new WarningSafeCellOfClassicMode());
	}

	public void interactFlag() {
		this.characteristics.interactFlag();
	}

	public void Bombfy() {
		this.characteristics.setProfile(new MinedCell());
	}

	public Coordinates getCellPosition() {
		return this.position;
	}

	public CoveredState getCellState() {
		return this.characteristics.getCoveredState();
	}

	public void analyzeLoss(GameStatus gameStatus) {
		this.characteristics.analyzeLoss(gameStatus);

	}

	public void analyzeWin(Field field, GameStatus gameStatus) {
		characteristics.analyzeWin(field, gameStatus);

	}

	public void passPlayerIndexFilter(GameplayManager gameplayManager) {
		characteristics.passPlayerIndexFilter(gameplayManager);
	}

}
