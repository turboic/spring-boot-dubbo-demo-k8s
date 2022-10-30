package org.apache.dubbo.springboot.demo.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ConsumerApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        log.info("consumer service started");
        new SpringApplicationBuilder(ConsumerApplication.class).run(args);
    }
}
