package com.exercise.printing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PrintingControllerTest {

    ColourConverter colourConverter = new ColourConverter();

    TestData testData = new TestData();

    PrintingController printingController;

    @Before
    public void setUp() {
        printingController = new PrintingController(colourConverter, testData);
    }

    @Test
    public void imageToColourPositiveTest() throws IOException {

        //what
        String url = "https://pwintyimages.blob.core.windows.net/samples/stars/sample-black.png";

        //when
        String imageColours = printingController.imageToColour(url, 3);

        //then
        assertEquals(imageColours.toString(), "black");
    }

    @Test
    public void imageToColourNegativeTest() throws IOException {

        //what
        String url = "https://pwintyimages.blob.core.windows.net/samples/stars/sample-navy.png";

        //when
        String imageColours = printingController.imageToColour(url, 3);

        //then
        assertEquals(imageColours.toString(), "Colour not in dictionary");
    }

    @Test
    public void imageToColourNoSearchTest() throws IOException {

        //what
        String url = "https://pwintyimages.blob.core.windows.net/samples/stars/sample-black.png";

        //when
        String imageColours = printingController.imageToColour(url, 1);

        //then
        assertEquals(imageColours.toString(), "Colour not in dictionary");
    }
}
