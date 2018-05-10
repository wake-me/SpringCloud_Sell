package com.wenqi.order.message;

import com.wenqi.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author: 文琪
 * @Description: 消息接受
 * @Date: Created in 2018/4/12 下午3:16
 * @Modified By:
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process(Object message){
//        log.info("StreamReceiver:{}",message);
//    }

    /**
     * 接收orderDTO对象 消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO message){
        log.info("StreamReceiver:{}",message);
        //发送mq消息
        return "received.";
    }


    @StreamListener(StreamClient.INPUT2)
    public void process1(String message){
        log.info("StreamReceiver2:{}",message);
    }
}
