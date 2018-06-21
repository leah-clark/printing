package com.exercise.Domain;

public class Name {
    private String value;
    private String closest_named_hex;
    private Boolean exact_match_name;
    private int distance;

    public String getValue() {
        return value;
    }

    public String getClosest_named_hex() {
        return closest_named_hex;
    }

    public Boolean getExact_match_name() {
        return exact_match_name;
    }

    public int getDistance() {
        return distance;
    }
}
