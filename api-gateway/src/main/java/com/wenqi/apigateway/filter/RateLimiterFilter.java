package com.wenqi.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.wenqi.apigateway.exception.RateLimiterException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @Author: 文琪
 * @Description: 限流拦截器
 * @Date: Created in 2018/4/16 上午10:09
 * @Modified By:
 */
@Component
public class RateLimiterFilter extends ZuulFilter {

    private static  final RateLimiter RATE_LIMITER =  RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    // 限流要给最高的优先级
    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        if (!RATE_LIMITER.tryAcquire()){
            throw  new RateLimiterException();
        }
        return null;
    }
}
