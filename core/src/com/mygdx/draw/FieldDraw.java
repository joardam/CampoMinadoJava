package com.mygdx.draw;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.gameField.GameField;

public class FieldDraw {
	GameField field;
	int spriteSize;
	
	public FieldDraw(GameField field,int spriteSize){
		this.field = field;
		this.spriteSize = spriteSize;
	}
	
	public void drawField(SpriteBatch sprite , Texture texture) {
		int[][] matrix = field.getMatrix();
		int apparentRows = field.getRows() - 2;
		int apparentCols = field.getCols() - 2;
		
		for (int row = 1; (row <= apparentRows); row++) {
			for (int col = 1; col <= (apparentCols); col++) {
				
				int x = matrix[row][col] * spriteSize;
				int y = 0;
				int width = spriteSize;
				int height = spriteSize;
				
				int renderX = row * spriteSize;
				int renderY = col * spriteSize;
				
				TextureRegion region = new TextureRegion(texture,x,y,width,height);
				sprite.draw(region,renderX, renderY);
								
		
			}
		}
		
	
	
	}
	
	
}
