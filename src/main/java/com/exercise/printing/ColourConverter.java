package com.exercise.printing;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class ColourConverter {

    private long redCounter;
    private long greenCounter;
    private long blueCounter;
    private long pixels;

    public String getColour(BufferedImage image, int variance) {
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
        String colourRGB = buildColourResult(redCounter/pixels, greenCounter/pixels, blueCounter/pixels);
        return colourRGB;
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

    public String buildColourResult(long redPixels, long greenPixels, long bluePixels) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rgb=");
        stringBuilder.append(redPixels);
        stringBuilder.append(",");
        stringBuilder.append(greenPixels);
        stringBuilder.append(",");
        stringBuilder.append(bluePixels);
        return stringBuilder.toString();
    }

}
