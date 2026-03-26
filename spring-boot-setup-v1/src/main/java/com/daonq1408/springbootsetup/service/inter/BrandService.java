package com.daonq1408.springbootsetup.service.inter;

import com.daonq1408.springbootsetup.dto.request.v1.BrandRequest;
import com.daonq1408.springbootsetup.dto.response.v1.BrandResponse;
import com.daonq1408.springbootsetup.entity.Brand;

import java.util.List;

public interface BrandService {
    Brand getBrandById(long brandId);

    BrandResponse getBrandResponseById(long brandId);

    List<BrandResponse> getAll();

    BrandResponse create(BrandRequest brandRequest);

    BrandResponse update(long brandId, BrandRequest brandRequest);

    BrandResponse delete(long brandId);
}
