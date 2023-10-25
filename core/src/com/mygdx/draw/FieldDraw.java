package com.mygdx.draw;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.config.VideoSettings;
import com.mygdx.gameField.FieldCell;
import com.mygdx.gameField.FieldCell.CellPosition;
import com.mygdx.gameField.GameField;

public class FieldDraw {
	GameField field;
	int spriteSize;
	
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
				
				innerTexture = cellInCol.getInnerTexture();
				
				position = cellInCol.getCellPosition();
				
				posX = position.getPosX();
				posY = position.getPosY();
				
				
				int x = innerTexture * spriteSize;
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
