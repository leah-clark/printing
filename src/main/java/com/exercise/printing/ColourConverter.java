package com.exercise.printing;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColourConverter {

    private long redCounter;
    private long greenCounter;
    private long blueCounter;
    private long pixels;

    public String getColour(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        redCounter = 0;
        greenCounter = 0;
        blueCounter = 0;
        pixels = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int pixel = image.getRGB(j, i);
                countPixelARGB(pixel);
            }
        }
        StringBuilder colourResult = buildColourResult();
        return colourResult.toString();
    }

    public void countPixelARGB(int pixel) {
        Color mycolor = new Color(pixel);
        int red = mycolor.getRed();
        int green = mycolor.getGreen();
        int blue = mycolor.getBlue();
        redCounter += red;
        greenCounter += green;
        blueCounter += blue;
        pixels++;
    }

    public StringBuilder buildColourResult() {
        long redPixels = redCounter/pixels;
        long greenPixels = greenCounter/pixels;
        long bluePixels = blueCounter/pixels;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rgb(");
        stringBuilder.append(redPixels);
        stringBuilder.append(",");
        stringBuilder.append(greenPixels);
        stringBuilder.append(",");
        stringBuilder.append(bluePixels);
        stringBuilder.append(")");
        return stringBuilder;
    }
}
