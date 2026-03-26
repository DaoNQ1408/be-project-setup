package com.daonq.springbootsetupv2.modules.auth.mapper;

import com.daonq.springbootsetupv2.modules.auth.dto.response.UserResponse;
import com.daonq.springbootsetupv2.modules.auth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {
    UserResponse toResponse(User user);
}
