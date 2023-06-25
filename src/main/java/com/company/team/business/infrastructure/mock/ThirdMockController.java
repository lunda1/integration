package com.company.team.business.infrastructure.mock;

import com.company.team.business.infrastructure.adapter.acl.dto.ThirdLeadDTO;
import com.company.team.business.infrastructure.adapter.acl.dto.req.FindNewLeadsReq;
import com.company.team.business.infrastructure.adapter.acl.dto.req.FindRetentionLeadsReq;
import com.company.team.business.infrastructure.adapter.acl.dto.res.FindNewLeadsRes;
import com.company.team.business.infrastructure.adapter.acl.dto.res.FindRetentionLeadsRes;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mock/third")
@Validated
@RequiredArgsConstructor
@Slf4j
@Tag(name = "ThirdMockController")
public class ThirdMockController {

    @PostMapping("/findNewLeads")
    public FindNewLeadsRes findNewLeads(@RequestBody FindNewLeadsReq req) {
        List<ThirdLeadDTO> list = new ArrayList<>();
        list.add(ThirdLeadDTO.builder().id("100").name("third100").build());
        return FindNewLeadsRes.builder().list(list).build();
    }

    @PostMapping("/findRetentionNewLeads")
    public FindRetentionLeadsRes findRetentionNewLeads(@RequestBody FindRetentionLeadsReq req) {
        List<ThirdLeadDTO> list = new ArrayList<>();
        list.add(ThirdLeadDTO.builder().id("1").name("third1").build());
        list.add(ThirdLeadDTO.builder().id("2").name("third2").build());
        return FindRetentionLeadsRes.builder().list(list).build();
    }
}
