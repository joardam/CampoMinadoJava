package com.mygdx.gameField.cell.characteristics;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.covered.flagged.FlaggedOfTwoPlayersMode;
import com.mygdx.gameField.cell.characteristics.state.covered.notFlagged.NotFlaggedOfTwoPlayersMode;
import com.mygdx.gameField.cell.characteristics.state.uncovered.UncoveredForTwoPlayersMode;
import com.mygdx.gameField.gameplayManager.RoundPlayerManager;

public class CharacteristicsOfTwoPlayersMode extends Characteristics {

	public CharacteristicsOfTwoPlayersMode(FieldCell cell) {
		super(cell);
		profile = new CompleteSafeCellOfClassicMode();
		coveredState = new NotFlaggedOfTwoPlayersMode();
	}
 
	
	public void startAnalyzeInteraction(RoundPlayerManager roundManager) {
		coveredState.analyzeStart(this);
	}





	@Override
	public void setFlagged() {
		coveredState = new FlaggedOfTwoPlayersMode(); 
	}



	@Override
	public void setNotFlagged() {
		coveredState = new NotFlaggedOfTwoPlayersMode(); 
	}





	@Override
	public void uncover() {
		coveredState = new UncoveredForTwoPlayersMode();
		
	}
	
}
