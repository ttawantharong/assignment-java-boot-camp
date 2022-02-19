package com.ttawantharong.assignmentjavabootcamp.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;
    private String title;
    private double normalPrice;
    private int discountPercentage;
    private double price;
    private int rating;
    private String description;

    public Product(){

    }

    public Product(int id, String title, double normalPrice, int discountPercentage, double price) {
        this.id = id;
        this.title = title;
        this.normalPrice = normalPrice;
        this.discountPercentage = discountPercentage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(double normalPrice) {
        this.normalPrice = normalPrice;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
