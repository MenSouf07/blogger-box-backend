package com.dauphine.blogger.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("hello-world")
    public String helloWord() {
        return "Hello Wolrd!";
    }

    @GetMapping("hello/{name}")
    public String helloByName(@PathVariable String name) {
        return "Hello " + name + " !";
    }
    
    @GetMapping("hello")
    public String helloByNameV2(@RequestParam String name) {
        return "Hello " + name + " !";
    }
}
