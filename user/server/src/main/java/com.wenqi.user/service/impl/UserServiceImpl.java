package com.wenqi.user.service.impl;

import com.wenqi.user.dao.UserInfoDao;
import com.wenqi.user.entity.UserInfo;
import com.wenqi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/16 下午1:42
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoDao infoDao;

    /**
     *  通过openid查询用户信息
     * @param openid
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openid) {

        return infoDao.findByOpenid(openid);
    }
}
