package com.daonq.springbootsetupv2.modules.auth.service;

import com.daonq.springbootsetupv2.common.response.PagedResponse;
import com.daonq.springbootsetupv2.modules.auth.dto.response.UserResponse;
import com.daonq.springbootsetupv2.modules.auth.filter.UserFilterRequest;

public interface UserService {
    PagedResponse<UserResponse> search(UserFilterRequest filter);
}
