package com.daonq1408.springbootsetup.repository;

import com.daonq1408.springbootsetup.entity.Brand;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAllByIsDeletedFalse();

    Optional<Brand> findByIdAndIsDeletedFalse(Long id);

    boolean existsByBrandCodeAndIdNotAndIsDeletedFalse(
            String brandCode,
            Long brandId
    );

    boolean existsByBrandCodeAndIsDeletedFalse(String brandCode);
}
