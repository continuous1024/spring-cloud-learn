package com.huanyu.cloud.learn.example.ribbon.service.impl;

import com.huanyu.cloud.learn.example.ribbon.service.HelloWorldService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHelloFallback")
    @Override
    public String sayHello(String name) {
        return restTemplate.getForObject("http://HELLO-WORLD-EXAMPLE/hi?name="+name, String.class);
    }

    public String sayHelloFallback(String name) {
        return "Hello, " + name + "! Sorry error!!!";
    }
}
