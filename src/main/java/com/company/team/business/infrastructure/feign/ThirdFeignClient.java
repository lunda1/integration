package com.company.team.business.infrastructure.feign;

import com.company.team.business.infrastructure.adapter.acl.dto.req.FindNewLeadsReq;
import com.company.team.business.infrastructure.adapter.acl.dto.req.FindRetentionLeadsReq;
import com.company.team.business.infrastructure.adapter.acl.dto.res.FindNewLeadsRes;
import com.company.team.business.infrastructure.adapter.acl.dto.res.FindRetentionLeadsRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mock-third-remote-service", url = "http://localhost:8080/integration/mock/third")
public interface ThirdFeignClient {

    @GetMapping("/findNewLeads")
    FindNewLeadsRes findNewLeads(@RequestBody FindNewLeadsReq req);

    @GetMapping("/findRetentionNewLeads")
    FindRetentionLeadsRes findRetentionLeads(@RequestBody FindRetentionLeadsReq req);
}

