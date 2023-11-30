package com.mygdx.gameField.cell.characteristics.state;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;

public interface CellStateInterface {
	public void interactFlag(Characteristics characteristics);
	public int analyzeWin(int counter);	
		
		
	
	
}
