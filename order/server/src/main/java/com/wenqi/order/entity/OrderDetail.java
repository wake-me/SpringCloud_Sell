package com.wenqi.order.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: 文琪
 * @Description: 订单详情表
 * @Date: Created in 2018/1/12 下午9:54
 * @Modified By:
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    /**
     * 详情ID.
     */
    @Id
    private String detailId;// varchar(32) NOT NULL,

    /**
     * 订单ID.
     */
    private String orderId; // varchar(32) NOT NULL,

    /**
     * 商品ID.
     */
    private String productId; // varchar(32) NOT NULL,

    /**
     * 商品名称.
     */
    private String productName; // varchar(64) NOT NULL COMMENT '商品名称',

    /**
     * 当前价格.
     */
    private BigDecimal productPrice; // decimal(8,2) NOT NULL COMMENT '当前价格,单位分',

    /**
     * 数量
     */
    private Integer productQuantity; //` int(11) NOT NULL COMMENT '数量',

    /**
     * 小图
     */
    private String productIcon;// varchar(512) DEFAULT NULL COMMENT '小图',

//    /** 创建时间 */
//    private Date createTime; // timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//
//    /** 修改时间 */
//    private Date updateTime; // timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',

}
