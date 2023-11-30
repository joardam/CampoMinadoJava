package com.mygdx.gameField.cell.characteristics.state.covered;

import com.mygdx.gameField.Field;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.cell.characteristics.state.CoveredState;


public abstract class Covered extends CoveredState{
	
	
	@Override
	public int analyzeWin(int counter) {
		counter++;
		return counter;
	}

	

//	@Override
//	public void analyzeWorking(Field field, FieldCell fieldCell) {
//		characteristics.passToProfileAnalyzeWorking();
//		
//	}
	
	
	
	
	

}

