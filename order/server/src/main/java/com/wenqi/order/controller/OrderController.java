package com.wenqi.order.controller;

import com.wenqi.order.converter.OrderForm2OrderDTOConverter;
import com.wenqi.order.dto.OrderDTO;
import com.wenqi.order.enums.ResultEnum;
import com.wenqi.order.exception.SellException;
import com.wenqi.order.form.OrderForm;
import com.wenqi.order.server.OrderService;
import com.wenqi.order.util.HttpResult;
import com.wenqi.order.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/12 上午10:37
 * @Modified By:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public HttpResult<Map<String, String>> create(@Valid OrderForm orderForm,
                                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultUtil.success(map);

    }


    /**
     * 完结订单（只能卖家调用）
     * @param orderId
     * @return
     */
    @PostMapping("/finish")
    public HttpResult<OrderDTO> finish(@RequestParam String orderId) {
        return ResultUtil.success(orderService.finish(orderId));
    }

}
