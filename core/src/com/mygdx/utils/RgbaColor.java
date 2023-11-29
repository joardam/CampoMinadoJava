package com.mygdx.utils;

public class RgbaColor {
    float[] rgba = new float[4];

    public RgbaColor(String colorString) {
        switch (colorString.toLowerCase()) {
            case "green":
                this.rgba[0] = 0f;
                this.rgba[1] = 1f;
                this.rgba[2] = 0f;
                this.rgba[3] = 1f;
                break;
            case "red":
                this.rgba[0] = 1f;
                this.rgba[1] = 0f;
                this.rgba[2] = 0f;
                this.rgba[3] = 1f;
                break;
            case "blue":
                this.rgba[0] = 0f;
                this.rgba[1] = 0f;
                this.rgba[2] = 1f;
                this.rgba[3] = 1f;
                break;
            case "gray":
                this.rgba[0] = 0.5f;
                this.rgba[1] = 0.5f;
                this.rgba[2] = 0.5f;
                this.rgba[3] = 1f;
                break;
            case "purple":
                this.rgba[0] = 0.5f;
                this.rgba[1] = 0f;
                this.rgba[2] = 0.5f;
                this.rgba[3] = 1f;
                break;
            case "white": 
                this.rgba[0] = 1f;
                this.rgba[1] = 1f;
                this.rgba[2] = 1f;
                this.rgba[3] = 1f;
                break;
            case "black": 
                this.rgba[0] = 0f;
                this.rgba[1] = 0f;
                this.rgba[2] = 0f;
                this.rgba[3] = 1f;
                break;
            case "yellow":
                this.rgba[0] = 1f;
                this.rgba[1] = 1f;
                this.rgba[2] = 0f;
                this.rgba[3] = 1f;
                break;
            case "pearl_white":
                this.rgba[0] = 1f;
                this.rgba[1] = 0.984f; 
                this.rgba[2] = 0.933f;  
                this.rgba[3] = 1f;
                break;
            case "dark_gray":
            	 	this.rgba[0] = 0.3f;   
            	    this.rgba[1] = 0.3f;   
            	    this.rgba[2] = 0.3f;   
            	    this.rgba[3] = 1f;
                break;

            default:
                throw new IllegalArgumentException("Unknown color: " + colorString);
        }
    }

    public float[] getColor() {
        return this.rgba;
    }
}
