package com.wenqi.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @ Author: 文琪
 * @ Description:
 * @ Date: Created in 2018/1/23 上午12:48
 * @ Modified By:
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotBlank(message = "姓名必填")
    private String name;

    /**
     * 买家手机号码
     */
    @NotBlank(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotBlank(message = "地址必填")
    private String address;

    /**
     * 买家微信openId
     */
    @NotBlank(message = "openid必填")
    private String openid;

    /**
     * 购物车不能为空
     */
    @NotBlank(message = "购物车不能为空")
    private String items;
}
