package com.mygdx.gameField.cell.characteristics;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.cellprofile.safeCell.CompleteSafeCellOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.covered.flagged.FlaggedOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.covered.notFlagged.NotFlaggedOfClassicMode;
import com.mygdx.gameField.cell.characteristics.state.uncovered.UncoveredOfClassicMode;

public class CharacteristicsOfClassicMode extends Characteristics {

	public CharacteristicsOfClassicMode(FieldCell cell) {
		super(cell);
		profile = new CompleteSafeCellOfClassicMode();
		coveredState = new NotFlaggedOfClassicMode();
		
	}

	@Override
	public void uncover() {
		coveredState = new UncoveredOfClassicMode();
		
	}

	@Override
	public void interactFlag() {
		super.interactFlag();
	}

	@Override
	public void setFlagged() {
		coveredState = new FlaggedOfClassicMode();
		
	}
	
	
	
	

}
