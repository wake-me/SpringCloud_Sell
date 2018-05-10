package com.wenqi.order.enums;

import lombok.Getter;

/**
 * @Author: 文琪
 * @Description: 支付状态
 * @Date: Created in 2018/1/12 下午9:48
 * @Modified By:
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    WAIT(1, "等待支付"),
    SUCCESS(2, "支付成功");

    private Integer code;

    private String massage;

    PayStatusEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }
}
