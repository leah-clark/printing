package com.exercise.printing;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ColourConverterTest {

    @Test
    public void getTealColourTest() {
        try {
            ColourConverter colourConverter = new ColourConverter();
            File testImg = new File("src/test/resources/images/tempImg.png");
            BufferedImage image =
                    ImageIO.read(testImg);
            assertEquals(colourConverter.getColour(image),"rgb(13,106,117)");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getBlackColourTest() {
        try {
            ColourConverter colourConverter = new ColourConverter();
            File testImg = new File("src/test/resources/images/testImage.jpg");
            BufferedImage image =
                    ImageIO.read(testImg);
            assertEquals(colourConverter.getColour(image),"rgb(48,48,48)");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
