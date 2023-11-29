package com.mygdx.gameField.cell.characteristics.state.covered.notFlagged;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.covered.Covered;


public abstract class NotFlagged extends Covered{

	@Override
	public void interactFlag(Characteristics characteristics) {
		characteristics.setFlagged();
		
	}



}
