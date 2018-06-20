package com.exercise.printing;

import java.util.ArrayList;

public class PrinterResponse {
    private final String colour;
    private final String imageUrl;

    public PrinterResponse(String colour, String imageUrl) {
        this.colour = colour;
        this.imageUrl = imageUrl;
    }

    public String getColour() {
        return colour;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
