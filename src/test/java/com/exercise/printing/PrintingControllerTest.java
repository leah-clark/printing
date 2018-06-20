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
    public void imageToColourTest() throws IOException {

        //what
        String url = "https://pwintyimages.blob.core.windows.net/samples/stars/sample-black.png";

        //when
        ArrayList<String> imageColours = printingController.imageToColour(url, 3);

        //then
        assertEquals(imageColours.toString(), "[rgb(48,48,48), rgb(48,48,49), rgb(48,48,50)," +
                " rgb(48,49,48), rgb(48,49,49), rgb(48,49,50), rgb(48,50,48), rgb(48,50,49), rgb(48,50,50), rgb(49,48,48), " +
                "rgb(49,48,49), rgb(49,48,50), rgb(49,49,48), rgb(49,49,49), rgb(49,49,50), rgb(49,50,48), rgb(49,50,49)," +
                " rgb(49,50,50), rgb(50,48,48), rgb(50,48,49), rgb(50,48,50), rgb(50,49,48), rgb(50,49,49), rgb(50,49,50)," +
                " rgb(50,50,48), rgb(50,50,49), rgb(50,50,50)]");
    }
}
