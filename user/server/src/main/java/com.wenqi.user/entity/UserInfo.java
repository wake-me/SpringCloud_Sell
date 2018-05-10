package com.wenqi.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/16 下午1:33
 * @Modified By:
 */
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;

}
