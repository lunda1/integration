package com.company.team.business.infrastructure.adapter.acl.dto.res;

import com.company.team.business.infrastructure.adapter.acl.dto.ThirdLeadDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindNewLeadsRes {
    private List<ThirdLeadDTO> list;
}
