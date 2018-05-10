package com.wenqi.order.dao;

import com.wenqi.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/3/26 下午3:14
 * @Modified By:
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
