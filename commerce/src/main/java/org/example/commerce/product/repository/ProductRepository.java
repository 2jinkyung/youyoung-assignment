package org.example.commerce.product.repository;

import org.example.commerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>,ProductCustomRepository {
}
