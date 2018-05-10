package com.wenqi.user.controller;

import com.wenqi.user.constant.CookieConstant;
import com.wenqi.user.constant.RedisConstant;
import com.wenqi.user.entity.UserInfo;
import com.wenqi.user.enums.ResultEnum;
import com.wenqi.user.enums.RoleEnum;
import com.wenqi.user.exception.SellException;
import com.wenqi.user.service.UserService;
import com.wenqi.user.util.CookieUtil;
import com.wenqi.user.util.HttpResult;
import com.wenqi.user.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/16 下午1:46
 * @Modified By:
 */
@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 买家登录
     *
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public HttpResult buyer(@RequestParam("openid") String openid,
                            HttpServletResponse response) {


        //1. 验证参数
        if (StringUtils.isEmpty(openid)) {
            log.info("【买家登录】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), "openid为空");
        }
        //2. openid 和数据库里的是否数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            log.info("【买家登录】 未找到用户，openid={}", openid);
            throw new SellException(ResultEnum.LOGIN_FAIL);
        }
        //3. 判断角色
        if (RoleEnum.BUYER.getCode() != userInfo.getRole()){
            log.info("【买家登录】用户角色不一致，role=",userInfo.getRole());
            throw new SellException(ResultEnum.ROLE_ERROR);
        }
        //4. cookie里设置openid
        CookieUtil.set(response,CookieConstant.OPENID,openid,CookieConstant.expire);
        return ResultUtil.success();
    }

    @GetMapping("/seller")
    public HttpResult seller(@RequestParam("openid") String openid,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        // 判断是否已经登录
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookie != null && !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue()))) ){
            return ResultUtil.success();
        }
        //1. 验证参数
        if (StringUtils.isEmpty(openid)) {
            log.info("【卖家登录】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), "openid为空");
        }
        //2. openid 和数据库里的是否数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            log.info("【卖家登录】 未找到用户，openid={}", openid);
            throw new SellException(ResultEnum.LOGIN_FAIL);
        }
        //3. 判断角色
        if (RoleEnum.SELLER.getCode() != userInfo.getRole()){
            log.info("【卖家登录】用户角色不一致，role=",userInfo.getRole());
            throw new SellException(ResultEnum.ROLE_ERROR);
        }

        //4. redis设置key=UUID, value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),
                openid,
                expire,
                TimeUnit.SECONDS);

        //5. cookie里设置openid
        CookieUtil.set(response,CookieConstant.TOKEN,token,CookieConstant.expire);

        return ResultUtil.success();
    }
}
