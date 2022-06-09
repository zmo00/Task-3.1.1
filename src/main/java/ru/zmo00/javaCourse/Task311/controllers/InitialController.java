package ru.zmo00.javaCourse.Task311.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitialController {

    @GetMapping
    public String start() {
        return "hello";
    }

}
