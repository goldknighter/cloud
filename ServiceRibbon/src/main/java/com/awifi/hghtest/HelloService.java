package com.awifi.hghtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
    @Autowired RestTemplate restTemplate;

    //断路器
    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String getHelloContent() {
        System.out.println("call CONFIG-CLIENT");
        return restTemplate.getForObject("http://CONFIG-CLIENT/",String.class);
    }

    public String serviceFailure() {
        return "hello world service is not available !";
    }
}