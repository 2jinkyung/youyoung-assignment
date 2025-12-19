package org.example.commerce.product.service;

import lombok.AllArgsConstructor;
import org.example.commerce.order.entity.Order;
import org.example.commerce.order.entity.OrderDto;
import org.example.commerce.order.repository.OrderRepository;
import org.example.commerce.product.entity.Product;
import org.example.commerce.product.entity.ProductCreateDto;
import org.example.commerce.product.entity.ProductDto;
import org.example.commerce.product.repository.ProductRepository;
import org.example.commerce.user.entity.User;
import org.example.commerce.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;
    //목록 조회
    public Page<ProductDto> findProducts(String keyword, Pageable pageable) {
        Page<Product> findProducts= productRepository.findAllProducts(keyword,pageable);
        return new PageImpl<>(
                findProducts.stream().map(ProductDto::toDto).toList(),
                findProducts.getPageable(),
                findProducts.getTotalElements()
        );
    }


    //주문 생성
    @Transactional
    public OrderDto createProduct(Long userId, ProductCreateDto createDto){
        User userEntity = userRepository.findByUserId(userId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"사용자를 찾을 수 없습니다."));

        Product productEntity = productRepository.findByNameContains(createDto.getName())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"상품을 찾을 수 없습니다."));

        if(productEntity.getCount() < createDto.getCount()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,createDto.getCount() - productEntity.getCount() + "개의 재고가 부족합니다.");
        }
        if(productEntity.getCount() == 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"주문 가능한 재고가 없습니다.");
        }
        userRepository.save(userEntity);
        productEntity.orderCount(createDto.getCount());
        productRepository.save(productEntity);

        return OrderDto.toDto(
                orderRepository.save(
                        Order.builder()
                                .user(userEntity)
                                .product(productEntity)
                                .orderCount(createDto.getCount())
                                .build()
                )
        );
    }
}
