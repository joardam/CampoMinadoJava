package com.mygdx.draw;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.gameField.cell.FieldCell;
import com.mygdx.gameField.cell.FieldCell.CellPosition;
import com.mygdx.gameField.GameField;

public class FieldDraw {
	private final GameField field;
	private final int spriteSize;
	
	public FieldDraw(GameField field,int spriteSize){
		this.field = field;
		this.spriteSize = spriteSize;
	}
	
	
	
	public void drawField(SpriteBatch sprite, Texture texture) {
		FieldCell[][] cells = field.getCells();
		for(FieldCell[] cellsByCol: cells) {
			for(FieldCell cellInCol : cellsByCol) {
				CellPosition position;
				int posX;
				int posY;
				int innerTexture;
				
				int textureId = CellTextureManager.getTextureByCell(cellInCol);
				
				position = cellInCol.getCellPosition();
				
				posX = position.getPosX();
				posY = position.getPosY();
				
				
				int x = textureId * spriteSize;
				int y = 0;
				int width = spriteSize;
				int height = spriteSize;
				
				int renderX = posX * spriteSize;
				int renderY = posY * spriteSize;
				
				TextureRegion region = new TextureRegion(texture,x,y,width,height);
				sprite.draw(region,renderX, renderY);
				
				
			}
		
		}
		
	}
	
	
	
}
