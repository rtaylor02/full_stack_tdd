package com.rodtaylor02.full_stack_tdd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-rod")
    public String helloWorld() {
        return "Hello Rod";
    }
}
