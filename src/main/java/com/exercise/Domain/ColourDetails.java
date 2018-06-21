package com.exercise.Domain;

public class ColourDetails {
    private Hex hex;
    private Rgb rgb;
    private Hsl hsl;
    private Hsv hsv;
    private Name name;
    private Cmyk cmyk;
    private Xyz XYZ;
    private ImageColour image;
    private Contrast contrast;
    private LinksColour _links;
    private EmbeddedColour embedded;

    public Hex getHex() {
        return hex;
    }

    public Rgb getRgb() {
        return rgb;
    }

    public Hsl getHsl() {
        return hsl;
    }

    public Hsv getHsv() {
        return hsv;
    }

    public Name getName() {
        return name;
    }

    public Cmyk getCmyk() {
        return cmyk;
    }

    public Xyz getXyz() {
        return XYZ;
    }

    public ImageColour getImage() {
        return image;
    }

    public Contrast getContrast() {
        return contrast;
    }

    public LinksColour get_links() {
        return _links;
    }

    public EmbeddedColour getEmbedded() {
        return embedded;
    }
}
