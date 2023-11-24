package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CellState;


public abstract class Covered extends CellState{
	@Override
	public void analyzeWorking(Characteristics characteristics) {
		characteristics.passToProfileAnalyzeWorking();
	}
}

