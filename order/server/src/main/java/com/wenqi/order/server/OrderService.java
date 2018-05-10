package com.wenqi.order.server;

import com.wenqi.order.dto.OrderDTO;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/12 上午10:26
 * @Modified By:
 */
public interface OrderService {


    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);


}
