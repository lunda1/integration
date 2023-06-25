package com.company.team.business.infrastructure.adapter.ohs;

import com.company.team.business.common.Result;
import com.company.team.business.infrastructure.adapter.acl.ThirdPartyAdapter;
import com.company.team.business.infrastructure.adapter.acl.dto.req.FindNewLeadsReq;
import com.company.team.business.infrastructure.adapter.acl.dto.req.FindRetentionLeadsReq;
import com.company.team.business.infrastructure.adapter.acl.dto.res.FindNewLeadsRes;
import com.company.team.business.infrastructure.adapter.acl.dto.res.FindRetentionLeadsRes;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
@Validated
@AllArgsConstructor
@Slf4j
@Tag(name = "BusinessController")
public class BusinessController {

    ThirdPartyAdapter thirdPartyAdapter;

    @PostMapping("/findNewLeads")
    public Result<FindNewLeadsRes> findNewLeads(@RequestBody FindNewLeadsReq req) {
        log.info("manually trigger findNewLeads...");
        return Result.success(thirdPartyAdapter.findNewLeads(req));
    }

    @PostMapping("/findRetentionNewLeads")
    public Result<FindRetentionLeadsRes> findRetentionNewLeads(@RequestBody FindRetentionLeadsReq req) {
        log.info("manually trigger findRetentionNewLeads...");
        return Result.success(thirdPartyAdapter.findRetentionLeads(req));
    }
}
