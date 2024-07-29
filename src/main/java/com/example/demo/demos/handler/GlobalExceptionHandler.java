package com.example.demo.demos.handler;

import com.example.demo.demos.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e)
    {
        System.out.println(e.getMessage());
        return Result.error(e.getMessage());
    }
}
