package com.wenqi.order.dao;

import com.wenqi.order.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/3/26 下午3:12
 * @Modified By:
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);


}
