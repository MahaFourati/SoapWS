package com.test.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.soap.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
