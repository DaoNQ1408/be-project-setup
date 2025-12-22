package com.daonq1408.springbootsetup.dto.request.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest {

    private String name;
    private String description;
    private String brandCode;
}
