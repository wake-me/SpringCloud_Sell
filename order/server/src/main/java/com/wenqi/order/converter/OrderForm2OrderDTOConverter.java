package com.wenqi.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wenqi.order.dto.OrderDTO;
import com.wenqi.order.entity.OrderDetail;
import com.wenqi.order.enums.ResultEnum;
import com.wenqi.order.exception.SellException;
import com.wenqi.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 文琪
 * @Description: 订单表单对象转换成订单DTO
 * @Date: Created in 2018/1/23 上午1:02
 * @Modified By:
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());

        } catch (Exception e) {
            log.error("【对象装换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

}
