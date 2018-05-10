package com.wenqi.product.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/3/20 上午9:48
 * @Modified By:
 */
@Aspect
@Component
@Slf4j
public class HttpAspect {

    @Pointcut("execution(public * com.wenqi.isell.controller.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        //url
        log.info("url= {}", request.getRequestURI());

        //method
        log.info("method= {}", request.getMethod());

        //ip
        log.info("ip= {}", request.getRemoteAddr());

        //类方法
        log.info("class_method= {}", joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());

        //参数
        log.info("args= {}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {

    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response= {}", object.toString());
    }
}
