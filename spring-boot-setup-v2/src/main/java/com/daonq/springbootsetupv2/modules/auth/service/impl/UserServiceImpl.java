package com.daonq.springbootsetupv2.modules.auth.service.impl;

import com.daonq.springbootsetupv2.common.response.PagedResponse;
import com.daonq.springbootsetupv2.modules.auth.dto.response.UserResponse;
import com.daonq.springbootsetupv2.modules.auth.filter.UserFilterRequest;
import com.daonq.springbootsetupv2.modules.auth.mapper.UserMapper;
import com.daonq.springbootsetupv2.modules.auth.predicate.UserPredicateBuilder;
import com.daonq.springbootsetupv2.modules.auth.repository.UserRepository;
import com.daonq.springbootsetupv2.modules.auth.service.UserService;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserPredicateBuilder userPredicateBuilder;


    @Override
    @Transactional(readOnly = true)
    public PagedResponse<UserResponse> search(UserFilterRequest filter) {
        Predicate predicate = userPredicateBuilder.build(filter);
        Pageable pageable = filter.toPageable();

        Page<UserResponse> page = userRepository
                .findAll(predicate, pageable)
                .map(userMapper::toResponse);

        return PagedResponse.from(page);
    }
}
