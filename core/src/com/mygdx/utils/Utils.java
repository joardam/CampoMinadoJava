package com.mygdx.utils;


import java.util.Random;

public class Utils {
    public static int randomBetween(int x , int y) {

        Random random = new Random();

        int randomNumber = random.nextInt((y - x) + 1) + x;
        
        return randomNumber;
        
    }
}
