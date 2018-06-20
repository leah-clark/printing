package com.exercise.printing;

import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PrintingController {

    @RequestMapping(value="/printing/{image}", method= GET)
    public PrinterResponse printing(@RequestParam(value="image", defaultValue="Invalid") String image) throws IOException {
        saveImage(image, "src/main/resources/images/tempImg.png");
        return new PrinterResponse("blue",
                String.format(image));
    }

    public static void saveImage(final String imageUrl, final String destinationFile) throws IOException {
        final URL url = new URL(imageUrl);
        final HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();

        File outputfile = new File(destinationFile);
        outputfile.createNewFile();

        final InputStream is = urlConnection.getInputStream();
        final OutputStream os = new FileOutputStream(outputfile, false);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }

    public static void matchColourToApi() {

    }

}
