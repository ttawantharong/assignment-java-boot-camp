package com.ttawantharong.assignmentjavabootcamp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductControllers {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ProductResponse getProducts(@RequestParam String productTitle){

        Optional<List<Product>> result = productRepository.findByTitleContaining(productTitle);
        if(result.isPresent()) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProducts(result.get());
            return productResponse;
        }
        throw  new ProductNotFoundException(productTitle);
    }

}
