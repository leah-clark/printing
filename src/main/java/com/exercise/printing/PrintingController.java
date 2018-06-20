package com.exercise.printing;

import com.google.gson.Gson;
import com.sun.deploy.net.HttpResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

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
        ArrayList<String> colourRGB = imageToColour(image, Integer.parseInt(variance));
        return new PrinterResponse(colourRGB,
                String.format(image));
    }

    public ArrayList<String> imageToColour(final String imageUrl, int variance) throws IOException {
        final URL url = new URL(imageUrl);
        BufferedImage img = ImageIO.read(url);
        ArrayList<String> colourRGB = colourConverter.getColour(img, variance);
        return colourRGB;
    }

}
