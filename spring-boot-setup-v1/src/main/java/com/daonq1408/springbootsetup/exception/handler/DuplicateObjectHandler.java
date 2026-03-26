package com.daonq1408.springbootsetup.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.daonq1408.springbootsetup.dto.api.ApiResponse;
import com.daonq1408.springbootsetup.exception.exceptions.DuplicateObjectException;

@RestControllerAdvice
public class DuplicateObjectHandler {

    @ExceptionHandler(DuplicateObjectException.class)
    public ResponseEntity<ApiResponse<Void>> handleDuplicateObjectException(
            DuplicateObjectException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                e.getMessage());
        problemDetail.setTitle("Entity Already Exists");
        ApiResponse<Void> response = ApiResponse.error(
                HttpStatus.CONFLICT,
                "Entity Already Exists",
                problemDetail);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
