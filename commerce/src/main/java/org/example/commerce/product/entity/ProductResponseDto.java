package org.example.commerce.product.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.example.commerce.user.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponseDto {

    @Schema(description = "주문자명")
    private String UserName;

    @Schema(description = "상품명")
    private String name;

    @Schema(description = "주문 수량")
    private int count;

    public static ProductResponseDto toDto(User userEntity, Product productEntity, int orderCount) {
        return ProductResponseDto.builder()
                .UserName(userEntity.getName())
                .name(productEntity.getName())
                .count(orderCount)
                .build();
    }
}
