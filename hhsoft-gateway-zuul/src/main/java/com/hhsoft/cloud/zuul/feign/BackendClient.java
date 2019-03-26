package com.hhsoft.cloud.zuul.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

/**
 * @InterfaceName: BackendClient
 * @Description 后台管理服务中心Feign客户端(运程调用hhsoft-manage-backend中的服务)
 * @Author Jason Biao
 * @Date 2019/3/26 15:36
 * @Version 1.0
 **/
@FeignClient("manage-backend")
public interface BackendClient {

    /**
     * 查询所有黑名单IP
     * @param params
     * @return
     */
    @GetMapping("/backend-anon/internal/blackIPs")
    Set<String> findAllBlackIPs(@RequestParam("params") Map<String, Object> params);
}
