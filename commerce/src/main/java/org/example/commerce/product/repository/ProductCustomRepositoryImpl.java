package org.example.commerce.product.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.commerce.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.example.commerce.product.entity.QProduct.product;

@RequiredArgsConstructor
@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {


    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Product> findAllProducts(String keyword, Pageable pageable) {

        List<Product> findProduct= jpaQueryFactory.selectFrom(product)
                .where(
                    nameContains(keyword)
                )
                .orderBy(product.productId.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(findProduct, pageable, findAllCount(keyword));
    }

    private BooleanExpression nameContains(String keyword) {
        return (keyword.equals("")) ? null : product.name.contains(keyword);
    }
    
    //총 갯수
    public Long findAllCount(String keyword) {
        return jpaQueryFactory
                .select(product.count())
                .from(product)
                .where(
                        product.name.contains(keyword)
                )
                .fetchOne();
    }
}
