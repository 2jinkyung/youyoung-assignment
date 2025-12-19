package org.example.commerce.product.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCreateDto {

    @Schema(description = "상품명",defaultValue = "공책")
    private String name;

    @Schema(description = "주문 수량",defaultValue = "5")
    private int count;

}
