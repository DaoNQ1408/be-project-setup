package com.daonq1408.springbootsetup.service.impl;

import com.daonq1408.springbootsetup.entity.Product;
import com.daonq1408.springbootsetup.repository.ProductRepository;
import com.daonq1408.springbootsetup.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl {

    private final ProductRepository productRepository;

    public List<Product> findAll(
            String name,
            Double minPrice,
            Double maxPrice,
            String brandCode,
            String categoryCode
    ) {
        List<Product> products = productRepository.findAll(
                ProductSpecification.filter(
                        name,
                        minPrice,
                        maxPrice,
                        brandCode,
                        categoryCode
                )
        );
        return products;
    }

    public List<Product> findAll2(
            String name,
            Double minPrice,
            Double maxPrice,
            String brandCode,
            String categoryCode
    ) {

        Specification<Product> specification = Specification.where(null);
        specification = specification.and(ProductSpecification.hasName(name));
        specification = specification.and(ProductSpecification.hasMinPrice(minPrice));
        specification = specification.and(ProductSpecification.hasMaxPrice(maxPrice));
        specification = specification.and(ProductSpecification.hasBrandCode(brandCode));
        specification = specification.and(ProductSpecification.hasCategoryCode(categoryCode));
        List<Product> products = productRepository.findAll(specification);


        return products;
    }
}
