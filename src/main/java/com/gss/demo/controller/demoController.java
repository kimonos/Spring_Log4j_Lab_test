package com.gss.demo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class demoController {

    @GetMapping("/")
    public String welcome() {
        return "Hello this project is Log4j Lab which has SQLi and Log4j vulnerabilities";
    }

    @GetMapping("/view")
    public String view() {
        return "Hello, How are you?";
    }
}
