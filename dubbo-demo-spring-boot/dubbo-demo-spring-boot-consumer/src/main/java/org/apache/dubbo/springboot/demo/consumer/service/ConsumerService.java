package org.apache.dubbo.springboot.demo.consumer.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.springboot.demo.DemoService;
import org.springframework.stereotype.Service;
@EnableDubbo
@Service
public class ConsumerService {
    @DubboReference
    private DemoService demoService;

    public String sayHello(String name) {
        return demoService.sayHello(name);
    }


    public Object demo(String param) {
        return demoService.demo(param);
    }
}
