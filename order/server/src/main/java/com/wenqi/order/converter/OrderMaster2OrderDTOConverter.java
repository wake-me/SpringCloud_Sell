package com.wenqi.order.converter;


import com.wenqi.order.dto.OrderDTO;
import com.wenqi.order.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 文琪
 * @Description: 订单详情转换成订单DTO
 * @Date: Created in 2018/1/18 下午11:42
 * @Modified By:
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster master) {

        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(master, orderDTO);

        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());


    }
}
