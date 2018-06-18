package com.exercise.printing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintingController {


    private static final String template = "Hello, %s!";

    @RequestMapping("/printing")
    public Printer printing(@RequestParam(value="name", defaultValue="Invalid") String name) {
        return new Printer(734873,
                String.format(template, name));
    }
}
