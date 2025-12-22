package com.daonq1408.springbootsetup.specification;

import com.daonq1408.springbootsetup.entity.Brand;
import com.daonq1408.springbootsetup.entity.Category;
import com.daonq1408.springbootsetup.entity.Product;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {
    // version 1: viết tất cả điều kiện lọc trong 1 hàm
    public static Specification<Product> filter (
            String name,
            Double minPrice,
            Double maxPrice,
            String brandCode,
            String categoryCode
    ) {
        return (root, query, cb) -> {
            // dùng để join product với brand và category
            Join<Product, Brand> brand = root.join("brand", JoinType.INNER);
            Join<Product, Category> category = root.join("category", JoinType.INNER);

            // list các điều kiện lọc
            List<Predicate> predicates = new ArrayList<>();

            if(name != null ) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if(minPrice != null ) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
            }
            if(maxPrice != null ) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
            }
            if(brandCode != null ) {
                predicates.add(cb.equal(brand.get("brandCode"), brandCode));
            }
            if(categoryCode != null ) {
                predicates.add(cb.equal(category.get("categoryCode"), categoryCode));
            }

            query.distinct(true);

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    // version 2: tách từng điều kiện lọc thành các hàm riêng biệt
    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Product> hasMinPrice(Double minPrice) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> hasMaxPrice(Double maxPrice) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> hasBrandCode(String brandCode) {
        return (root, query, cb) -> {
            Join<Product, Brand> brand = root.join("brand", JoinType.INNER);
            return cb.equal(brand.get("brandCode"), brandCode);
        };
    }

    public static Specification<Product> hasCategoryCode(String categoryCode) {
        return (root, query, cb) -> {
            Join<Product, Category> category = root.join("category", JoinType.INNER);
            return cb.equal(category.get("categoryCode"), categoryCode);
        };
    }
}
