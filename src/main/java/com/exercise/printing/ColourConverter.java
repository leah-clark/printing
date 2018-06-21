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

    public ArrayList<String> getColour(BufferedImage image, int variance) {
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
        ArrayList<String> colourList = createPermutations(variance);
        return colourList;
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

    public ArrayList<String> createPermutations(int variance) {
        ArrayList<String> colourList = new ArrayList<String>();
        long redPixels = redCounter/pixels;
        long greenPixels = greenCounter/pixels;
        long bluePixels = blueCounter/pixels;
        for(int i = 0; i<variance; i++) {
            for(int j=0; j<variance; j++) {
                for(int k=0; k<variance; k++) {
                    colourList.add(buildColourResult(redPixels+i,greenPixels+j,bluePixels+k));
                }
            }
        }
        return colourList;
    }

    public HashMap<String, String> colours() throws IllegalAccessException {
        HashMap<String, String> map = new HashMap<>();
        for (Field f : Color.class.getFields()) {
            if (f.getType() == Color.class) {
                Color c = (Color) f.get(null);
                int blue = c.getBlue();
                int green = c.getGreen();
                int red = c.getRed();
                map.put(buildColourResult(red, green, blue), f.getName());
            }
        }
        return map;
    }

    public String buildColourResult(long redPixels, long greenPixels, long bluePixels) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rgb(");
        stringBuilder.append(redPixels);
        stringBuilder.append(",");
        stringBuilder.append(greenPixels);
        stringBuilder.append(",");
        stringBuilder.append(bluePixels);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}
