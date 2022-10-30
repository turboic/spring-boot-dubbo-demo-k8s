package org.apache.dubbo.springboot.demo.consumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        log.info("Exception异常:{}", e);
        return Result.failure(e.getMessage());
    }

    @ExceptionHandler(Error.class)
    public Result exceptionHandler(Error e) {
        log.info("Error异常:{}", e);
        return Result.failure(e.getMessage());
    }
}
