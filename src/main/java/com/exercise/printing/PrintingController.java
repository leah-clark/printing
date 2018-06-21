package com.exercise.printing;

import com.exercise.Domain.ColourDetails;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
        String colourRGB = colourConverter.getColour(img, variance);
        ColourDetails colourDetails = getColourFromJson("http://thecolorapi.com/id?"+colourRGB);
        return colourDetails.getName().getValue();
    }

    public ColourDetails getColourFromJson(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ColourDetails colourDetails = mapper.readValue(new URL(url), ColourDetails.class);
        return colourDetails;
    }
}
