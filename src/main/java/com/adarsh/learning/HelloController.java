package com.adarsh.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/check")
    public String hello(){
        return "Hello, Spring Boot is working! 🎉";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Adarsh's Spring Boots Application!";
    }
}
