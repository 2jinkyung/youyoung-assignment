package org.example.commerce.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.commerce.product.entity.Product;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "user_id")
    private Long userId;

    @Comment("사용자 이름")
    @Column(nullable = false, name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Product> products = new ArrayList<>();
}
