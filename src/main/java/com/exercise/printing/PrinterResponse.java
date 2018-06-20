package com.exercise.printing;

import java.util.ArrayList;

public class PrinterResponse {
    private final ArrayList<String> colours;
    private final String imageUrl;

    public PrinterResponse(ArrayList<String> colours, String imageUrl) {
        this.colours = colours;
        this.imageUrl = imageUrl;
    }

    public ArrayList<String> getColours() {
        return colours;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
