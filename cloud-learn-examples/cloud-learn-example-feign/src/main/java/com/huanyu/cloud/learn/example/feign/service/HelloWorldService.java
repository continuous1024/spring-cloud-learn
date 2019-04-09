package com.huanyu.cloud.learn.example.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HELLO-WORLD-EXAMPLE", fallback = HelloWorldServiceHystrix.class)
public interface HelloWorldService {

    @GetMapping(value = "/hi")
    String sayHello(@RequestParam(value = "name") String name);
}
