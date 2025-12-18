package org.example.commerce.product.entity;

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

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "count")
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
