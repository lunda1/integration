package com.company.team.business.infrastructure.adapter.ohs;

import com.company.team.business.common.Result;
import com.company.team.business.infrastructure.adapter.acl.ThirdAdapter;
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

@RestController
@RequestMapping("/third-manual")
@Validated
@RequiredArgsConstructor
@Slf4j
@Tag(name = "ThirdManualController")
public class ThirdManualController {

    ThirdAdapter thirdAdapter;

    @PostMapping("/findNewLeads")
    public Result<FindNewLeadsRes> findNewLeads(@RequestBody FindNewLeadsReq req) {
        log.info("manually trigger findNewLeads...");
        return Result.success(thirdAdapter.findNewLeads(req));
    }

    @PostMapping("/findRetentionNewLeads")
    public Result<FindRetentionLeadsRes> findRetentionNewLeads(@RequestBody FindRetentionLeadsReq req) {
        log.info("manually trigger findRetentionNewLeads...");
        return Result.success(thirdAdapter.findRetentionLeads(req));
    }
}
