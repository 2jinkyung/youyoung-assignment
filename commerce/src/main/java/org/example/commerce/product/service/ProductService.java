package org.example.commerce.product.service;

import lombok.AllArgsConstructor;
import org.example.commerce.product.entity.Product;
import org.example.commerce.product.entity.ProductDto;
import org.example.commerce.product.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    //목록 조회
    public Page<ProductDto> findProducts(String keyword, Pageable pageable) {
        Page<Product> findProducts= productRepository.findAllProducts(keyword,pageable);
        return new PageImpl<>(
                findProducts.stream().map(ProductDto::toDto).toList(),
                findProducts.getPageable(),
                findProducts.getTotalElements()
        );
    }
}
