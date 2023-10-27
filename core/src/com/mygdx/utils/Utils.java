package com.mygdx.utils;


import java.util.Random;

public class Utils {
    public static int randomBetween(int min , int max) {

        Random random = new Random();

        int randomNumber = random.nextInt((max - min) + 1) + min;
        
        return randomNumber;
    }
    
    public static boolean isIn2DArrayBound(int ArrayPosX , int ArrayPosY, int cols , int rows) {
    	return (((ArrayPosX >= 0) && (ArrayPosX < cols)) && ((ArrayPosY >= 0) && (ArrayPosY < rows)));
    }
    
    public static boolean isIn2DArrayBound(Coordinates coordinate ,int cols , int rows) {
    	int ArrayPosX = coordinate.getCoordinateX();
    	int ArrayPosY = coordinate.getCoordinateY();
    	
    	return (isIn2DArrayBound(ArrayPosX,ArrayPosY,cols,rows));
    	
    	
    }
    
    
    
    
    
    
    
}
