package com.exercise.printing;

import com.exercise.Domain.ColourDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PrintingControllerTest {

    ColourConverter colourConverter = new ColourConverter();


    PrintingController printingController;

    @Before
    public void setUp() {
        printingController = new PrintingController(colourConverter);
    }

    @Test
    public void imageToColourPositiveTest() throws IOException {

        //what
        String url = "https://pwintyimages.blob.core.windows.net/samples/stars/sample-black.png";

        //when
        String imageColours = printingController.imageToColour(url, 3);

        //then
        assertEquals(imageColours.toString(), "Mine Shaft");
    }

    @Test
    public void imageToColourNavyTest() throws IOException {

        //what
        String url = "https://pwintyimages.blob.core.windows.net/samples/stars/sample-navy.png";

        //when
        String imageColours = printingController.imageToColour(url, 3);

        //then
        assertEquals(imageColours.toString(), "Arapawa");
    }

    @Test
    public void getColourFromJsonTest() throws IOException {
        //what
        String url = "http://thecolorapi.com/id?rgb=13,106,171";

        //when
        ColourDetails colourDetails = printingController.getColourFromJson(url);

        //then
        assertEquals(colourDetails.getName().getValue(),"Green Blue");

    }
}
