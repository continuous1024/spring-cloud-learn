package com.huanyu.cloud.learn.example.ribbon.service.impl;

import com.huanyu.cloud.learn.example.ribbon.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String sayHello(String name) {
        return restTemplate.getForObject("http://HELLO-WORLD-EXAMPLE/hi?name="+name, String.class);
    }
}
