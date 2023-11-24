package com.mygdx.gameField.cell.characteristics.state;

import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.characteristics.Characteristics;

public interface CellStateInterface {
	public void analyzeStart(Characteristics characteristics);
	public void analyzeWorking(Characteristics characteristics);
	public void interactFlag(Characteristics characteristics);
		
		
	
	
}
