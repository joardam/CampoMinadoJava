package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.config.VideoSettings;
import com.mygdx.gameField.GameField;


public class MyGdxGame extends ApplicationAdapter {
	
	int rows = 12;
	int cols = 12;
	int spriteSize = 32;
	
	
	VideoSettings videoConfig = new VideoSettings(rows,cols,spriteSize);
	GameField field = new GameField(rows,cols);
	
	
	@Override
	public void create () {
		
        videoConfig.setWindowedMode();
        videoConfig.setResizable(false);
        videoConfig.setTitle("Campo Minado");
           
        field.fillMatrixes();
        int[][] matrix = field.getMatrix();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); 
        }
        
        
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
        SpriteBatch spriteBatch = new SpriteBatch();
        spriteBatch.begin();
        spriteBatch.end();
		
	}
	
	@Override
	public void dispose () {
		
	}
}
