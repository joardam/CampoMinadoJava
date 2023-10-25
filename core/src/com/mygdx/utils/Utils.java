package com.mygdx.utils;


import java.util.Random;

public class Utils {
    public static int randomBetween(int min , int max) {

        Random random = new Random();

        int randomNumber = random.nextInt((max - min) + 1) + min;
        
        return randomNumber;
        
    }
}
