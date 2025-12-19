package org.example.commerce.order.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.example.commerce.product.entity.Product;
import org.example.commerce.user.entity.User;
import org.hibernate.annotations.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDto {

    @Schema(description = "아이디")
    private Long orderId;

    @Schema(description = "사용자명")
    private String userName;

    @Schema(description = "제품명")
    private String productName;

    @Schema(description = "주문 수량")
    private int orderCount;


    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .orderId(order.getOrderId())
                .userName(order.getUser().getName())
                .productName(order.getProduct().getName())
                .orderCount(order.getOrderCount())
                .build();
    }


}
