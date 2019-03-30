package com.huanyu.cloud.learn.example.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class CloudLearnExampleHelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudLearnExampleHelloWorldApplication.class, args);
    }

    @Value("${server.port}")
    private int port;

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "huanyu") String name) {
        return "Hello, " + name + "! I'm from port " + port;
    }
}
