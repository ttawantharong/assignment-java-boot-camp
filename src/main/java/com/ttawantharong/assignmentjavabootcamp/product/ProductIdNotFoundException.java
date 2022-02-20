package com.ttawantharong.assignmentjavabootcamp.product;

public class ProductIdNotFoundException extends RuntimeException{
    public ProductIdNotFoundException(int id) {
        super(id+"");
    }
}
