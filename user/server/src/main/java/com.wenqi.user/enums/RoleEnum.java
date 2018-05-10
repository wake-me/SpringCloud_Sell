package com.wenqi.user.enums;

import lombok.Getter;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/16 下午2:07
 * @Modified By:
 */
@Getter
public enum  RoleEnum {

    BUYER(1,"买家"),
    SELLER(2,"卖家")

    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
