package com.ttawantharong.assignmentjavabootcamp.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<List<Product>> findByTitleContaining(String productTitle);

}
