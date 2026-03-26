package com.daonq.springbootsetupv2.common.filter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Set;

@Getter
@Setter
public class BaseFilter {

    @Min(0)
    private int page = 0;

    @Min(1)
    @Max(100)
    private int size = 10;

    private String sortBy = "id";
    private String sortDir = "asc";

    protected Set<String> allowedSortFields() {
        return Set.of("id");
    }

    public Pageable toPageable() {
        String saveSortBy = allowedSortFields().contains(sortBy) ? sortBy : "id";
        Sort sort = "desc".equalsIgnoreCase(sortDir)
                ? Sort.by(saveSortBy).descending()
                : Sort.by(saveSortBy).ascending();
        return PageRequest.of(page, size, sort);
    }
}
