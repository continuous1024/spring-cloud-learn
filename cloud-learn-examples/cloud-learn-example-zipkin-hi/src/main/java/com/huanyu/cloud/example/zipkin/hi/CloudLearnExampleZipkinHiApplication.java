package com.huanyu.cloud.example.zipkin.hi;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class CloudLearnExampleZipkinHiApplication {

    public static final Logger LOGGER = Logger.getLogger(CloudLearnExampleZipkinHiApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(CloudLearnExampleZipkinHiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hi() {
        LOGGER.log(Level.INFO, "trace service zipkin-hi-example");
        return restTemplate.getForObject("http://localhost:9097/world", String.class);

    }

    @GetMapping("/info")
    public String info() {
        LOGGER.log(Level.INFO, "service zipkin-hi-example info is being called");
        return "I'm zipkin-hi-example.";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
