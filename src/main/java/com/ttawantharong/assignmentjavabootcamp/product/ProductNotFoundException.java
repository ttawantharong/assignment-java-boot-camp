package com.ttawantharong.assignmentjavabootcamp.product;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String name) {
        super(name);
    }
}
