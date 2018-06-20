package com.exercise.printing;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class TestData {

    ////Test in contorller based on spec from email

    public String matchToColour(ArrayList<String> colourRGB) {
        for(String colour: colourRGB) {
            if (getTestPredefinedList().containsKey(colour)) {
                return getTestPredefinedList().get(colour);
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
