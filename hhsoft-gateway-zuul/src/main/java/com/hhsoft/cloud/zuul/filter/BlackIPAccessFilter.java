package com.hhsoft.cloud.zuul.filter;

import com.hhsoft.cloud.zuul.feign.BackendClient;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *黑名单IP拦截<br>
 *黑名单ip变化不会太频繁，<br>
 *考虑到性能，我们不实时掉接口从别的服务获取了，<br>
 *而是用定时任务把黑名单ip列表同步到网关层,
 *
 * @ClassName: BlackIPAccessFilter
 * @Description 黑名单IP网关过滤器
 * @Author Jason Biao
 * @Date 2019/3/26 16:12
 * @Version 1.0
 **/
@Component
public class BlackIPAccessFilter extends ZuulFilter {

    @Autowired
    private BackendClient backendClient;

    /**
     * 黑名单列表
     */
    private Set<String> blackIPs = new HashSet<>();

    @Override
    public boolean shouldFilter() {
        //如果不是黑名单
        if (blackIPs.isEmpty()) {
            return false;
        }

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //获取请求的真实ip地址
        String ip = getIpAddress(request);

        // 判断ip是否在黑名单列表里
        return blackIPs.contains(ip);
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        requestContext.setResponseBody("black ip");
        requestContext.setSendZuulResponse(false);

        return null;
    }

    /**
     *同filterType类型中，order值越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器类型
     * 顺序: pre ->routing -> post ,以上3个顺序出现异常时都可以触发error类型的filter
     *
     * pre:可以在请求被路由之前调用
     *
     * route:在路由请求的时候被调用
     *
     * post:在route和error过滤器之后被调用
     *
     * error:处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 定时同步黑名单IP
     */
    @Scheduled(cron = "${cron.black-ip}")
    public void syncBlackIPList() {
        try {
            Set<String> list = backendClient.findAllBlackIPs(Collections.emptyMap());
            blackIPs = list;
        } catch (Exception e) {
            // do nothing
        }
    }

    /**
     * 获取请求的真实ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
