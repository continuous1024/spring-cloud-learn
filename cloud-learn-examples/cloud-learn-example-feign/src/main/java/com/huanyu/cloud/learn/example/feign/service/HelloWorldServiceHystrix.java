package com.huanyu.cloud.learn.example.feign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceHystrix implements HelloWorldService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "! Sorry error!!!";
    }
}
