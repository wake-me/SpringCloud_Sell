package com.wenqi.order.controller;

import com.wenqi.order.dto.OrderDTO;
import com.wenqi.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/12 下午3:19
 * @Modified By:
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public void process(){
//        String message = "now"+new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }

    /**
     * 发送 orderDTO
     */
    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("张三李四王五");
//        String message = "now"+new Date();
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
