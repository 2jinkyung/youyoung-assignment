package org.example.commerce.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.commerce.order.entity.Order;
import org.hibernate.annotations.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_product")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "product_id")
    private Long productId;

    @Comment("상품명")
    @Column(nullable = false, name = "name")
    private String name;

    @Comment("가격")
    @Column(name = "price")
    private int price;

    @Comment("재고수량")
    @Column(name = "count")
    private int count;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public void orderCount(int count){
        this.count -= count;
    }

    public void cancelCount(int cancel){
        this.count += cancel;
    }
}
