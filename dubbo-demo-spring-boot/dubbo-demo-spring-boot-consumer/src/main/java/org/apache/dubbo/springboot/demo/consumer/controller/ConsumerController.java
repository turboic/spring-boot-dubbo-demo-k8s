package org.apache.dubbo.springboot.demo.consumer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.springboot.demo.consumer.config.Result;
import org.apache.dubbo.springboot.demo.consumer.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/consumer")
@Api(tags = "Dubbo服务消费者demo", value = "consumer接口")
public class ConsumerController {

    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ConsumerService consumerService;


    @ApiOperation(value = "sayHello")
    @GetMapping(value = "/sayHello")
    public Result sayHello(String name) {
        log.info("invoke consumer sayHello:{}", name);
        return Result.success("请求成功", consumerService.sayHello(name));
    }

    @ApiOperation(value = "ip")
    @PostMapping(value = "/ip")
    public Object demo(String ip) {
        log.info("invoke consumer ip:{}", ip);
        return Result.success("请求成功", consumerService.demo(ip));
    }
}
