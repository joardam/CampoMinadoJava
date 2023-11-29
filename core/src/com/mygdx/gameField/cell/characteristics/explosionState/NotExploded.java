package com.mygdx.gameField.cell.characteristics.explosionState;

import com.mygdx.gameField.cell.characteristics.Characteristics;
import com.mygdx.gameField.gameplayManager.gameStatus.GameStatus;

public class NotExploded extends ExplosionState
{

	@Override
	public void explosionChainWorking(Characteristics characteristics) {
		characteristics.uncover();
		characteristics.setExploded();
		characteristics.explosionChainWorking();
			
		}

	@Override
	public void startExplodeChain(Characteristics characteristics) {
		characteristics.explosionChainWorking();
		
		
	}

	@Override
	public void analyzeLoss(GameStatus gameStatus) {
		return;
		
		}
	}
	

