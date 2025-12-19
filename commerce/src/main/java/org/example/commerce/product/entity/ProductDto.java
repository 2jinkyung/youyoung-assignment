package org.example.commerce.product.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.example.commerce.user.entity.User;
import org.hibernate.annotations.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

    private Long productId;

    @Schema(description = "상품명")
    private String name;

    @Schema(description = "가격")
    private int price;

    @Schema(description = "재고 수량")
    private int count;


    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .count(product.getCount())
                .build();
    }

}
