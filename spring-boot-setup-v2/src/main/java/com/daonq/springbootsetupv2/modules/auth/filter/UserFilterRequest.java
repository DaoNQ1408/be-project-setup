package com.daonq.springbootsetupv2.modules.auth.filter;

import com.daonq.springbootsetupv2.common.filter.BaseFilter;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserFilterRequest extends BaseFilter {

    private String name;
//    private String email;
//    private Boolean active;
//    private Integer ageFrom;
//    private Integer ageTo;

    @Override
    protected Set<String> allowedSortFields() {
        return Set.of("id", "name"/*, "email", "age", "createdAt"*/);
    }
}
