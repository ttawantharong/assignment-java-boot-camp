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

    @ExceptionHandler(ProductIdNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponse ProductIdNotFound(ProductIdNotFoundException e){
        return new MessageResponse("Product id " + e.getMessage() + " not found");
    }
}
