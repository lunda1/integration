package com.company.team.business.infrastructure.adapter.acl;

import com.company.team.business.infrastructure.feign.ThirdPartyFeignClient;
import com.company.team.business.infrastructure.adapter.acl.dto.req.FindNewLeadsReq;
import com.company.team.business.infrastructure.adapter.acl.dto.req.FindRetentionLeadsReq;
import com.company.team.business.infrastructure.adapter.acl.dto.res.FindNewLeadsRes;
import com.company.team.business.infrastructure.adapter.acl.dto.res.FindRetentionLeadsRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ThirdPartyAdapter {

    ThirdPartyFeignClient thirdPartyFeignClient;

    public ThirdPartyAdapter(ThirdPartyFeignClient thirdFeignClient) {
        this.thirdPartyFeignClient = thirdFeignClient;
    }

    public FindNewLeadsRes findNewLeads(FindNewLeadsReq req) {
        return thirdPartyFeignClient.findNewLeads(req);
    }

    public FindRetentionLeadsRes findRetentionLeads(FindRetentionLeadsReq req) {
        return thirdPartyFeignClient.findRetentionLeads(req);
    }
}
