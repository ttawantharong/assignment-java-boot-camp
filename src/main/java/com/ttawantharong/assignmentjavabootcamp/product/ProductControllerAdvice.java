package com.ttawantharong.assignmentjavabootcamp.product;

import com.ttawantharong.assignmentjavabootcamp.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponse ProductNotFound(ProductNotFoundException e){
        return new MessageResponse("Product " + e.getMessage() + " not found");
    }
}
