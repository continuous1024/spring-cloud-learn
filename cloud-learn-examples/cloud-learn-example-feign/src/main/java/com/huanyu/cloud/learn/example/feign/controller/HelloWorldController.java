package com.huanyu.cloud.learn.example.feign.controller;

import com.huanyu.cloud.learn.example.feign.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hi")
    public String sayHello(@RequestParam String name) {
        return helloWorldService.sayHello(name);
    }
}
