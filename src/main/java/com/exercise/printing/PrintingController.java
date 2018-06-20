package com.exercise.printing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PrintingController {

    @Autowired
    ColourConverter colourConverter;

    @Autowired
    TestData testData;

    @Autowired
    PrintingController(ColourConverter colourConverter, TestData testData) {
        this.colourConverter = colourConverter;
        this.testData = testData;
    }

    @RequestMapping(value="/printing/{variance}/{image}", method= GET)
    public PrinterResponse printing(@RequestParam(value="image", defaultValue="Invalid") String image,
                                    @RequestParam(value = "variance", defaultValue = "3") String variance) throws IOException {
        String colourRGB = imageToColour(image, Integer.parseInt(variance));
        return new PrinterResponse(colourRGB,
                String.format(image));
    }

    public String imageToColour(final String imageUrl, int variance) throws IOException {
        final URL url = new URL(imageUrl);
        BufferedImage img = ImageIO.read(url);
        ArrayList<String> colourRGB = colourConverter.getColour(img, variance);
        String result = testData.matchToColour(colourRGB);
        return result;
    }
}
