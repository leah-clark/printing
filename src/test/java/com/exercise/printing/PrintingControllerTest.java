package com.exercise.printing;

import org.junit.Test;
import org.mockito.InjectMocks;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class PrintingControllerTest {

    @InjectMocks
    PrintingController printingController;

    @Test
    public void testSaveImage() throws IOException {
        //what
        String url = "https://pwintyimages.blob.core.windows.net/samples/stars/sample-black.png";
        String path = "src/test/resources/images/testImage.jpg";

        //when
        printingController.saveImage(url,path);

        //then
        File file = new File(path);
        assertTrue(file.exists());
        file.delete();
    }
}
