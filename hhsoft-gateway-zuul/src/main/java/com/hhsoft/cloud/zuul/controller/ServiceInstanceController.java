package com.hhsoft.cloud.zuul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ServiceInstanceController
 * @Description 获取注册中心各个微服务Controller
 * @Author Jason Biao
 * @Date 2019/3/26 10:53
 * @Version 1.0
 **/
@RestController
@RequestMapping("service-instances")
public class ServiceInstanceController {

    /**
     *进行eureka的发现服务
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     *获取各个微服务的信息实例
     * @return
     */
    @GetMapping
    public Map<String,Object> map(){

        Map<String,Object> map = new HashMap<>();
        //获取注册中心的所有的服务集合
        List<String> services = discoveryClient.getServices();
        //遍历获取注册中心所有服务的实例信息
        services.forEach(serviceId ->{
            //根据serviceId去获取服务的实例集合
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            map.put(serviceId,instances);
        });

        return map;
    }
}
