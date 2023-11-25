package com.mygdx.gameField.cell;

import com.mygdx.gameField.cell.characteristics.CharacteristicsOfTwoPlayersMode;

public class cellOfTwoPlayersMode extends ClassicCell {

	public cellOfTwoPlayersMode(int x, int y) {
		super(x, y);
		characteristics = new CharacteristicsOfTwoPlayersMode(this);
	}

}
