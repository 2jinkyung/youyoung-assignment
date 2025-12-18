package org.example.commerce.product.repository;

import org.example.commerce.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductCustomRepository {

    Page<Product> findAllProducts(String keyword,Pageable pageable);
}
