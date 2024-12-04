package org.niiish32x.fxsmsapp.openapi.feign;

import org.niiish32x.fxsmsapp.openapi.vo.ProtocolConfigVO;
import org.niiish32x.fxsmsapp.result.Result;
import org.niiish32x.fxsmsapp.openapi.vo.RegisterResponseVO;
import org.niiish32x.fxsmsapp.sms.service.runner.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * RegisterOpenApiFeign
 *
 * @author shenghao ni
 * @date 2024.12.04 15:26
 */
@FeignClient(name = "notification-admin", url = "${SUPOS_ADDRESS:http://localhost:8080}", configuration = ClientConfiguration.class)
public interface RegisterOpenApiFeign {


    /**
     * @return Result<RegisterResponseVO>
     * @author OpenAI
     * @date 2021-04-12 18:25:09
     */
    @PostMapping(value = "/open-api/notification-admin/v2/register")
    Result<RegisterResponseVO> register(@RequestHeader(name = "X-Tenant-Id") String suposAppTenantId, @RequestBody ProtocolConfigVO arg0);


}
