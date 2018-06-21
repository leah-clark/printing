package com.exercise.printing;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ColourConverterTest {

    @Test
    public void getTealColourTest() {
        try {
            ColourConverter colourConverter = new ColourConverter();
            File testImg = new File("src/test/resources/images/tempImg.png");
            BufferedImage image =
                    ImageIO.read(testImg);
            assertEquals(colourConverter.getColour(image, 3).get(0),"rgb(13,106,117)");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getColourMapTest() throws IllegalAccessException {
        //what
        ColourConverter colourConverter = new ColourConverter();

        //when
        HashMap<String, String> colourMap = colourConverter.colours();

        //then
        assertEquals(colourMap.get("rgb(0,255,0)"), "GREEN");
    }
}
