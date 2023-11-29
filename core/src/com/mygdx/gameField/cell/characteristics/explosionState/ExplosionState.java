package com.mygdx.gameField.cell.characteristics.explosionState;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public abstract class ExplosionState{

	public abstract void explosionChainWorking(Characteristics characteristics);

	public abstract void startExplodeChain(Characteristics characteristics);

	public abstract void analyzeLoss(GameStatus gameStatus);

}
