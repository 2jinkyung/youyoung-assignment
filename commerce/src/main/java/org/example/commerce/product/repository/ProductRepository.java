package org.example.commerce.product.repository;

import org.example.commerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long>,ProductCustomRepository {

    Optional<Product> findByNameContains(String name);


}
