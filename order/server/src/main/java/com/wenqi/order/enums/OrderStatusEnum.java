package com.wenqi.order.enums;

import lombok.Getter;

/**
 * @Author: 文琪
 * @Description: 订单状态枚举
 * @Date: Created in 2018/1/12 下午9:40
 * @Modified By:
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{

    NEW(1, "新订单"),
    FINISHED(2, "完结"),
    CANCEL(3, "已取消"),;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
