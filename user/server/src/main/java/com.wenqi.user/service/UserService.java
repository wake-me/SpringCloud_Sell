package com.wenqi.user.service;

import com.wenqi.user.entity.UserInfo;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/16 下午1:39
 * @Modified By:
 */
public interface UserService {

    /**
     *  通过openid查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
