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
            case "white": // Adicionando a cor branca
                this.rgba[0] = 1f;
                this.rgba[1] = 1f;
                this.rgba[2] = 1f;
                this.rgba[3] = 1f;
                break;
            case "black": // Adicionando a cor preta
                this.rgba[0] = 0f;
                this.rgba[1] = 0f;
                this.rgba[2] = 0f;
                this.rgba[3] = 1f;
                break;
            default:
                throw new IllegalArgumentException("Cor desconhecida: " + colorString);
        }
    }


    public float[] getColor() {
        return this.rgba;
    }
}
