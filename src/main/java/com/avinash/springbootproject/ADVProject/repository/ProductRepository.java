package com.avinash.springbootproject.ADVProject.repository;

import com.avinash.springbootproject.ADVProject.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
