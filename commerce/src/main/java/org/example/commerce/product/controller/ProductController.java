package org.example.commerce.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.example.commerce.product.service.ProductService;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController("/product")
public class ProductController {

    private final ProductService productService;

    @PageableAsQueryParam
    @Operation(summary = "상품 목록 조회", description = "상품 목록 조회")
    @GetMapping("")
    public ResponseEntity<?> getList(
            @Nullable String keyword,
            @Parameter(hidden = true) @PageableDefault(size = 5,sort = {"productId"}, direction = Sort.Direction.ASC) Pageable page
    ) {
        if(keyword == null) keyword = "";
        return new ResponseEntity<>(productService.findProducts(keyword, page), HttpStatus.OK);
    }
}
