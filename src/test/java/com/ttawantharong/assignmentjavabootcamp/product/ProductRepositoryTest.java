package com.ttawantharong.assignmentjavabootcamp.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("find product with NMD should return 1 record.")
    void findByTitleContainerFoundOneRecord(){
        Product product = new Product(1,"adidas ORIGINALS NMD R1 Shoes Men Black G55575", 4600.00,44,2576.00);
        productRepository.save(product);
        Optional<List<Product>> result = productRepository.findByTitleContaining("NMD");
        assertTrue(result.isPresent());
        assertEquals(1, result.get().size());
    }

    @Test
    @DisplayName("find product with NMD should return 0 record.")
    void findByTitleContainerNotFoundCase(){
        Product product = new Product(1,"adidas ORIGINALS NMD R1 Shoes Men Black G55575", 4600.00,44,2576.00);
        productRepository.save(product);
        Optional<List<Product>> result = productRepository.findByTitleContaining("iphone");
        assertEquals(0, result.get().size());
    }

}