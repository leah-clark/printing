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
import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PrintingController {

    @Autowired
    ColourConverter colourConverter;

    @Autowired
    PrintingController(ColourConverter colourConverter) {
        this.colourConverter = colourConverter;
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
        HashMap<String, String> testPredefinedList = getTestPredefinedList();
        String result = matchToColour(colourRGB, testPredefinedList);
        return result;
    }

    ////Test in contorller based on spec from email

    public String matchToColour(ArrayList<String> colourRGB, HashMap<String,String> testPredefinedList) {
        for(String colour: colourRGB) {
            if (testPredefinedList.containsKey(colour)) {
                return testPredefinedList.get(colour);
            }
        }
        return "Colour not in dictionary";
    }

    public HashMap<String, String> getTestPredefinedList() {
        HashMap<String, String> testPredefinedList = new HashMap<>();
        testPredefinedList.put("rgb(48,49,50)", "black");
       // testPredefinedList.put("rgb(14,14,90)","navy");
        testPredefinedList.put("rgb(13,107,119)","teal");
        testPredefinedList.put("rgb(67,82,96)","grey");
        return testPredefinedList;
    }

}
