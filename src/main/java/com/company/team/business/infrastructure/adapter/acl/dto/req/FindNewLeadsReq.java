package com.company.team.business.infrastructure.adapter.acl.dto.req;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class FindNewLeadsReq {
    private String id;
    private String name;
}
