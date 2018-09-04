package com.awifi.hghtest.com.awifi.hghtest.servicefeign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    HelloWorldService helloWorldFeignService;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        System.out.println("call servicefeign CONFIG-CLIENT");
        String remote = helloWorldFeignService.sayHello();
        System.out.println(remote);
        return remote;
    }
}