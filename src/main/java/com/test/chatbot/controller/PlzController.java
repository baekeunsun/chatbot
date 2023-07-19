package com.test.chatbot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlzController {

    @PostMapping("/ex/plz")
    public String add(@RequestBody String plz) {
        return "i want to go home";
    }
}
