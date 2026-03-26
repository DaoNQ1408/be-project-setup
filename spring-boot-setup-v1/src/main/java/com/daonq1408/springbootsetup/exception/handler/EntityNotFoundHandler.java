package com.daonq1408.springbootsetup.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.daonq1408.springbootsetup.dto.api.ApiResponse;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class EntityNotFoundHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleEntityNotFoundException(
            EntityNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                e.getMessage());
        problemDetail.setTitle("Entity Not Found");

        ApiResponse<Void> response = ApiResponse.error(
                HttpStatus.NOT_FOUND,
                "Entity Not Found",
                problemDetail);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
