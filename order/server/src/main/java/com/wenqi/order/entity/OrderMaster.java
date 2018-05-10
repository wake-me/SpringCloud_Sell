package com.wenqi.order.entity;

import com.wenqi.order.enums.OrderStatusEnum;
import com.wenqi.order.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 文琪
 * @Description: 订单主表
 * @Date: Created in 2018/3/26 下午2:59
 * @Modified By:
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /**
     * 订单id
     */
    @Id
    private String orderId;

    /**
     * 买家名称.
     */
    private String buyerName;

    /**
     * 买家手机号.
     */
    private String buyerPhone;

    /**
     * 买家地址.
     */
    private String buyerAddress;

    /**
     * 买家微信Openid.
     */
    private String buyerOpenid;

    /**
     * 订单金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单总额.
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode(); // tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',

    /**
     * 创建时间
     */
    private Date createTime; // timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    /**
     * 更新时间
     */
    private Date updateTime; // timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',


}
