package com.dauphine.blogger.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@Tag(
    name = "Hello world API",
    description = "My first hello world endpoints"
)
public class HelloWorldController {

    //http://localhost:1234/hello-world
    @GetMapping("hello-world")      
    public String helloWord() {
        return "Hello World!";
    }
    
    //http://localhost:1234/hello/Mendel
    @GetMapping("hello/{name}")     
    @Operation(
        summary = "Hello by name endpoint",
        description = "Returns 'Hello {name} ! by path variable"
    )
    public String helloByName(
        @Parameter(description = "Name to greet")
        @PathVariable String name
    ) {
        return "Hello " + name + " !";
    }

    //http://localhost:1234/hello?name=Mendel
    @GetMapping("hello")            
    @Operation(
        summary = "Hello by name V2 endpoint",
        description = "Returns 'Hello {name} ! by request param"
    )
    public String helloByNameV2(
        @Parameter(description = "Name to greet")
        @RequestParam String name
    ) {
        return "Hello " + name + " !";
    }
}
