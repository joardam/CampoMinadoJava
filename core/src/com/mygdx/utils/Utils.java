package com.mygdx.utils;


import java.util.Random;

public class Utils {
    public static int randomBetween(int min , int max) {

        Random random = new Random();

        int randomNumber = random.nextInt((max - min) + 1) + min;
        
        return randomNumber;
    }
    
    public static boolean isIn2DArrayBound(int arrayPosX , int arrayPosY, int cols , int rows) {
    	return (((arrayPosX >= 0) && (arrayPosX < cols)) && ((arrayPosY >= 0) && (arrayPosY < rows)));
    }
    
    public static boolean isIn2DArrayBound(Coordinates coordinate ,int cols , int rows) {
    	int arrayPosX = coordinate.getCoordinateX();
    	int arrayPosY = coordinate.getCoordinateY();
    	
    	return (isIn2DArrayBound(arrayPosX,arrayPosY,cols,rows));
    	
    }
    
    public static boolean isIn2DSpaceBound(float posX , float posY , float xInferiorLimit , float  yInferiorLimit ,float xSuperiorLimit ,float ySuperiorLimit ) {
    	return (((posX >= xInferiorLimit) && (posX < xSuperiorLimit)) && ((posY >= yInferiorLimit) && (posY < ySuperiorLimit)));
    }
    
}
