package com.wenqi.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wenqi.order.util.JsonUtil;
import com.wenqi.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 文琪
 * @Description: 商品服务 接受消息
 * @Date: Created in 2018/4/12 下午4:40
 * @Modified By:
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        // message => ProductInfoOutPut

      List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.fromJson(message,
              new TypeReference<List<ProductInfoOutput>>() {});
      log.info("从队列【{}】接收到消息:{}","productInfo",productInfoOutputList);

      for (ProductInfoOutput productInfoOutput: productInfoOutputList){
          // 存储到Redis
          stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),
                  String.valueOf(productInfoOutput.getProductStock()));
      }

    }
}
