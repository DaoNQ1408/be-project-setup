package com.daonq1408.springbootsetup.repository;

import com.daonq1408.springbootsetup.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDetails> findByMail(String mail);
}
