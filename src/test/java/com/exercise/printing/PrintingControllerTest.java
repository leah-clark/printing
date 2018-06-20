package com.exercise.printing;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
