package com.daonq.springbootsetupv2.modules.auth.controller;

import com.daonq.springbootsetupv2.common.response.ApiResponse;
import com.daonq.springbootsetupv2.common.response.PagedResponse;
import com.daonq.springbootsetupv2.modules.auth.dto.response.UserResponse;
import com.daonq.springbootsetupv2.modules.auth.filter.UserFilterRequest;
import com.daonq.springbootsetupv2.modules.auth.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<ApiResponse<PagedResponse<UserResponse>>> search(
            @Valid @ModelAttribute UserFilterRequest filter
    ) {
        return ResponseEntity.ok(ApiResponse.success(userService.search(filter)));
    }
}