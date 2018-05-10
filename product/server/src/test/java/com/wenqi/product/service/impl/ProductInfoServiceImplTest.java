package com.wenqi.product.service.impl;

import com.wenqi.common.ProductInfoOutput;
import com.wenqi.product.ProductApplicationTest;
import com.wenqi.product.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/23 下午3:24
 * @Modified By:
 */
@Slf4j
public class ProductInfoServiceImplTest extends ProductApplicationTest {

    @Autowired
    private ProductInfoService infoService;

    @Test
    public void findUpAll() {
    }

    @Test
    public void findList() {
        List<ProductInfoOutput> list = infoService.findList(Arrays.asList("1522640318980795289","123458"));
        Assert.assertFalse("查询订单商品",list.size()>0);
    }

    @Test
    public void decreaseStock() {
    }

    @Test
    public void decreaseStockProcess() {
    }
}