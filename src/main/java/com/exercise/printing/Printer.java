package com.exercise.printing;

public class Printer {
    private final long id;
    private final String colour;

    public Printer(long id, String colour) {
        this.id = id;
        this.colour = colour;
    }

    public long getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }
}
