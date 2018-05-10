package com.wenqi.user.dao;

import com.wenqi.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/16 下午1:37
 * @Modified By:
 */
public interface UserInfoDao extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);


}
