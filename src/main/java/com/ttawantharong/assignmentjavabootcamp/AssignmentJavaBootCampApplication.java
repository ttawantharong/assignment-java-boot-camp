package com.ttawantharong.assignmentjavabootcamp;

import com.ttawantharong.assignmentjavabootcamp.product.Product;
import com.ttawantharong.assignmentjavabootcamp.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AssignmentJavaBootCampApplication {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void insertData(){

		Product product = new Product(1,"adidas ORIGINALS NMD R1 Shoes Men Black G55575", 4600.00,44,2576.00);
		productRepository.save(product);

	}

	public static void main(String[] args) {
		SpringApplication.run(AssignmentJavaBootCampApplication.class, args);
	}

}
