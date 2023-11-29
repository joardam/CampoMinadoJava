package com.mygdx.gameField.cell;

import com.mygdx.gameField.cell.characteristics.CharacteristicsOfClassicMode;

public class ClassicCell extends FieldCell{

	public ClassicCell(int x, int y) {
		super(x, y);
		characteristics = new CharacteristicsOfClassicMode(this);
	}
	
}
