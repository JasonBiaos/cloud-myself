package com.hhsoft.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 过滤内部uri权限<br>
 * 该类uri不需要登陆，但又不允许外网通过网关调用，只允许微服务间在内网调用，<br>
 * 为了方便拦截此场景的uri，我们自己约定一个规范，及uri中含有-anon/internal<br>
 * 如在oauth登陆的时候用到根据username查询用户，<br>
 * 用户系统提供的查询接口/users-anon/internal肯定不能做登录拦截，而该接口也不能对外网暴露<br>
 * 如果有此类场景的uri，请用这种命名格式，
 *
 * @ClassName: InternalURIAccessFilter
 * @Description 过滤内部uri权限(对外网访问接口做的安全过滤)
 * @Author Jason Biao
 * @Date 2019/3/26 17:26
 * @Version 1.0
 **/
@Component
public class InternalURIAccessFilter extends ZuulFilter {

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        requestContext.setResponseBody(HttpStatus.FORBIDDEN.getReasonPhrase());
        requestContext.setSendZuulResponse(false);

        return null;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        return PatternMatchUtils.simpleMatch("*-anon/internal*", request.getRequestURI());
    }

    /**
     * filter执行顺序
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
}
