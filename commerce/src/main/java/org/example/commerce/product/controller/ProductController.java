package org.example.commerce.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.commerce.product.entity.ProductCreateDto;
import org.example.commerce.product.service.ProductService;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController("/product")
public class ProductController {

    private final ProductService productService;

    @PageableAsQueryParam
    @Operation(summary = "상품 목록 조회", description = "상품 목록 조회")
    @GetMapping("")
    public ResponseEntity<?> findPrdList(
            @Nullable String keyword,
            @Parameter(hidden = true) @PageableDefault(size = 5,sort = {"productId"}, direction = Sort.Direction.ASC) Pageable page
    ) {
        if(keyword == null) keyword = "";
        return new ResponseEntity<>(productService.findProducts(keyword, page), HttpStatus.OK);
    }

    @Operation(summary = "주문 생성", description = "사용자 상품 주문")
    @PostMapping("/{userId}/create")
    public ResponseEntity<?> createProduct (
            @Parameter @PathVariable Long userId,
            @Valid @RequestBody ProductCreateDto createDto)
     {
        return new ResponseEntity<>(productService.createProduct(userId, createDto), HttpStatus.OK);
    }

//    @PageableAsQueryParam
//    @Operation(summary = "사용자별 주문 목록 조회", description = "사용자별 주문 목록 조회")
//    @GetMapping("/{userId}")
//    public ResponseEntity<?> UserFindPrdList(
//            @PathVariable Long userId,
//            @Parameter(hidden = true) @PageableDefault(size = 5,sort = {"productId"}, direction = Sort.Direction.ASC) Pageable page
//    ) {
//        return new ResponseEntity<>(productService.findProducts(keyword, page), HttpStatus.OK);
//    }


}
