package com.daonq.springbootsetupv2.modules.auth.predicate;

import com.daonq.springbootsetupv2.modules.auth.entity.QUser;
import com.daonq.springbootsetupv2.modules.auth.filter.UserFilterRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component
public class UserPredicateBuilder {

    private static final QUser Q = QUser.user;

    public Predicate build(UserFilterRequest filter) {
        BooleanBuilder builder = new BooleanBuilder();

        Optional.ofNullable(filter.getName())
                .filter(StringUtils::hasText)
                .ifPresent(v -> builder.and(Q.name.containsIgnoreCase(v)));

        return builder;
    }
}
