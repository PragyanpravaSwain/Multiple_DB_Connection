package com.it.ig.bridge.authmultiuser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller123 {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
}
