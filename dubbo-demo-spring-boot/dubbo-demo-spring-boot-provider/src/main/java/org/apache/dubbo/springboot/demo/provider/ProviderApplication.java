package org.apache.dubbo.springboot.demo.provider;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"org.apache.dubbo.springboot.demo.provider"})
public class ProviderApplication {
    private static final Logger log = LoggerFactory.getLogger(ProviderApplication.class);

    com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase s;


    public static void main(String[] args) {
        log.info("dubbo-springboot-demo-provider service started");
        new SpringApplicationBuilder(ProviderApplication.class).run(args);
    }
}
