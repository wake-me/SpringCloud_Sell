package com.wenqi.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: 文琪
 * @Description: MQ消息接收器
 * @Date: Created in 2018/4/12 下午2:13
 * @Modified By:
 */
@Slf4j
@Component
public class MqReceiver {

    // 1. @RabbitListener(queues = "myQueue")
    //2. 自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3. 自动创建队列 Exchange和Queue绑定

    /**
     * 数码供应商服务  接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message){
        log.info("computer MqReceiver: {}", message);
    }

    /**
     *  水果服务商 接受消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message){
        log.info("Fruit MqReceiver: {}", message);
    }
}
