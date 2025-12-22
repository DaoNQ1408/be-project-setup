package com.daonq1408.springbootsetup.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageMeta {

    private int currentPage;
    private int size;
    private int lastPage;
}
