package com.mygdx.gameField.cell.characteristics.cellprofile;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.explosionState.Exploded;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public class MinedCell extends CellProfile {

	@Override
	public void revealInteract(FieldCell cell) {
		
	}

	@Override
	public void flagInteract(FieldCell cell) {
		return;
		
	}


	

	@Override
	public void setNearbyBombs(FieldCell cell) {
		return;
		
	}
	
	@Override
	public int countBomb(int counter) {
		counter++;
		return counter ;
		
	}


	

	

	@Override
	public void passRoundFilter(Characteristics characteristics, RoundPlayerManager roundManager) {
		return;
		
	}

	@Override
	public int getCellTextureId() {
		return 9;
	}

	@Override
	public void analyzeStart(Characteristics characteristics, Field field) {
		characteristics.startExplosionChain();
		
	}

	@Override
	public void analyzeWorking(Characteristics characteristics, Field field) {
		return;
		
	}

	
}
