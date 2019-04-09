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
public class CloudLearnExampleZipkinWorldApplication {

    public static final Logger LOGGER = Logger.getLogger(CloudLearnExampleZipkinWorldApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(CloudLearnExampleZipkinWorldApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/world")
    public String hi() {
        LOGGER.log(Level.INFO, "service zipkin-world-example world is being called");
        return "world is beautify!!!";
    }

    @GetMapping("/info")
    public String info() {
        LOGGER.log(Level.INFO, "trace service zipkin-world-example");
        return restTemplate.getForObject("http://localhost:9096/info", String.class);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
