package com.wenqi.product.enums;

import lombok.Getter;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/1/6 下午10:03
 * @Modified By:
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(1, "在架"),
    DOWN(2, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
