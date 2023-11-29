package com.mygdx.game.states.gameModeState.gameEndlessMode;

import com.mygdx.utils.FloatCoordinates;
import com.mygdx.utils.GameUtils;
import com.mygdx.utils.Region2d;

public class GameEndlessManager {
	public static boolean clickedPassGame(FloatCoordinates coordinatePos ,Region2d region ) {
		return GameUtils.isIn2DSpaceBound(coordinatePos, region);
		
	}
}
