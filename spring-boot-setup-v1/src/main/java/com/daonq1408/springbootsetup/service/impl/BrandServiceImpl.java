package com.daonq1408.springbootsetup.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daonq1408.springbootsetup.dto.request.v1.BrandRequest;
import com.daonq1408.springbootsetup.dto.response.v1.BrandResponse;
import com.daonq1408.springbootsetup.entity.Brand;
import com.daonq1408.springbootsetup.exception.exceptions.DuplicateObjectException;
import com.daonq1408.springbootsetup.mapper.BrandMapper;
import com.daonq1408.springbootsetup.repository.BrandRepository;
import com.daonq1408.springbootsetup.service.inter.BrandService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public Brand getBrandById(long brandId) {
        return brandRepository.findByIdAndIsDeletedFalse(brandId).orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + brandId));
    }

    @Override
    public BrandResponse getBrandResponseById(long brandId) {
        return brandRepository.findById(brandId).map(brandMapper::toResponse).orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + brandId));
    }

    @Override
    public List<BrandResponse> getAll() {
        return brandRepository.findAllByIsDeletedFalse().stream().map(brandMapper::toResponse).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    @Transactional
    public BrandResponse create(BrandRequest brandRequest) {
        validateBrandCodeUnique(brandRequest.getBrandCode(), null);

        Brand brand = brandMapper.toEntity(brandRequest);

        return saveAndReturn(brand);
    }

    @Override
    @Transactional
    public BrandResponse update(long brandId, BrandRequest brandRequest) {
        validateBrandCodeUnique(brandRequest.getBrandCode(), brandId);

        Brand brand = getBrandById(brandId);

        brandMapper.updateEntityFromRequest(brandRequest, brand);

        return saveAndReturn(brand);
    }

    @Override
    @Transactional
    public BrandResponse delete(long brandId) {
        Brand brand = getBrandById(brandId);

        brand.setIsDeleted(true);

        return saveAndReturn(brand);
    }

    private BrandResponse saveAndReturn(Brand brand) {
        Brand savedBrand = brandRepository.save(brand);
        return brandMapper.toResponse(savedBrand);
    }

    private void validateBrandCodeUnique(String brandCode, Long brandIdToExclude) {
        boolean exists;

        if (brandIdToExclude == null) {
            exists = brandRepository.existsByBrandCodeAndIsDeletedFalse(brandCode);
        } else {
            exists = brandRepository.existsByBrandCodeAndIdNotAndIsDeletedFalse(brandCode, brandIdToExclude);
        }

        if (exists) {
            throw new DuplicateObjectException("Brand code must be unique: " + brandCode);
        }
    }
}
