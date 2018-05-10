package com.wenqi.product.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/1 下午3:03
 * @Modified By:
 */
@Data
public class ProductForm {


    private String productId; // `product_id` varchar(32) NOT NULL,

    /**
     * 商品名称.
     */
    private String productName; // `product_name` varchar(64) NOT NULL COMMENT '商品名称',

    /**
     * 单价.
     */
    private BigDecimal productPrice; // decimal(8,2) NOT NULL COMMENT '单价',

    /**
     * 库存.
     */
    private Integer productStock; // int(11) NOT NULL COMMENT '库存',

    /**
     * 描述.
     */
    private String productDescription; // varchar(64) DEFAULT NULL COMMENT '描述',

    /**
     * 小图.
     */
    private String productIcon;// varchar(512) DEFAULT NULL COMMENT '小图',


    /**
     * 类目编号.
     */
    private Integer categoryType; // int(11) NOT NULL COMMENT '类目编号',
    //       `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    //        `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',

}
