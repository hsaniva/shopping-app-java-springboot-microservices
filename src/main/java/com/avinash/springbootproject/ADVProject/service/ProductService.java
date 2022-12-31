package com.avinash.springbootproject.ADVProject.service;

import com.avinash.springbootproject.ADVProject.dto.ProductRequest;
import com.avinash.springbootproject.ADVProject.dto.ProductResponse;
import com.avinash.springbootproject.ADVProject.model.Product;
import com.avinash.springbootproject.ADVProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product is save {}", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::getProductResponseObj).toList();
    }

    private ProductResponse getProductResponseObj(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
