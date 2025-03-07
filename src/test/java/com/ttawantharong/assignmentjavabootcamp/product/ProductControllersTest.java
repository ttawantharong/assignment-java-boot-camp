package com.ttawantharong.assignmentjavabootcamp.product;

import com.ttawantharong.assignmentjavabootcamp.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllersTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("user search with \"NMD\" should return 2 record")
    void getProductsFound() {
        Product product = new Product(1,"adidas ORIGINALS NMD R1 Shoes Men Black G55575", 4600.00,44,2576.00);
        Product product2 = new Product(2,"Adidas รองเท้า OG Men NMD_R1 Primeblue GZ9256", 4600.00,10,4140.00);

        List<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(product2);

        // Arrange
        when(productRepository.findByTitleContaining("NMD")).thenReturn(Optional.of(products));
        // Act
        ProductResponse  result = testRestTemplate.getForObject("/products?productTitle=NMD",ProductResponse.class);

        // Verify
        assertEquals(2, result.getProducts().size());
    }


    @Test
    @DisplayName("Users search for products that are not available in the system should return message \"Product iphone not found\"")
    void getProductsNotFound() {
        // Arrange
        when(productRepository.findByTitleContaining("NMD")).thenReturn(Optional.empty());
        // Act
        MessageResponse result = testRestTemplate.getForObject("/products?productTitle=iphone",MessageResponse.class);

        // Verify
        assertEquals("Product iphone not found", result.getMessage());
    }

    @Test
    @DisplayName("get product by id should return one product and product id must be equal param")
    void getProductFound() {
        Product product = new Product(2,"Adidas รองเท้า OG Men NMD_R1 Primeblue GZ9256", 4600.00,10,4140.00);

        // Arrange
        when(productRepository.findById(2)).thenReturn(Optional.of(product));
        // Act
        Product result = testRestTemplate.getForObject("/product/2",Product.class);
        // Verify
        assertEquals(2, result.getId());
    }

    @Test
    @DisplayName("get product by id should return one product and product id must be equal param")
    void getProductNotFound() {

        // Arrange
        when(productRepository.findById(1)).thenReturn(Optional.empty());
        // Act
        MessageResponse result = testRestTemplate.getForObject("/product/1",MessageResponse.class);
        // Verify
        assertEquals("Product id 1 not found", result.getMessage());
    }
}