package com.daonq1408.springbootsetup.dto.response.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponse {

    private Long id;
    private String name;
    private String description;
    private String brandCode;
    private Boolean isDeleted;
}
