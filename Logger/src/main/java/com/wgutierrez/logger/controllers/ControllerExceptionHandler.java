package com.wgutierrez.logger.controllers;

import com.wgutierrez.logger.transversal.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Response<Object> ExceptionHandler(Exception e) {
        Response<Object> response = new Response<>();

        response.setMessage(String.format("Message: %s || StackTrace: %s", e.getMessage(), e.getStackTrace().toString()));
        response.setIsWarning(false);
        response.setIsSuccess(false);

        return response;
    }
}
