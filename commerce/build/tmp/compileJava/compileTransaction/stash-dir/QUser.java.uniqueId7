package org.example.commerce.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1592165400L;

    public static final QUser user = new QUser("user");

    public final StringPath name = createString("name");

    public final ListPath<org.example.commerce.order.entity.Order, org.example.commerce.order.entity.QOrder> orders = this.<org.example.commerce.order.entity.Order, org.example.commerce.order.entity.QOrder>createList("orders", org.example.commerce.order.entity.Order.class, org.example.commerce.order.entity.QOrder.class, PathInits.DIRECT2);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

