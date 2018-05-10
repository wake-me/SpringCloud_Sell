package com.wenqi.product.dao;

import com.wenqi.common.ProductInfoOutput;
import com.wenqi.product.ProductApplicationTest;
import com.wenqi.product.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/12 下午1:46
 * @Modified By:
 */
@Component
@Slf4j
public class ProductInfoDaoTest extends ProductApplicationTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void findByProductStatus() {
    }

    @Test
    public void findByProductIdIn() {

        List<ProductInfo> infoOutputList = productInfoDao.findByProductIdIn(Arrays.asList("1522640318980795289","123458"));
        Assert.assertFalse("批量查询商品详情",infoOutputList.size()>0);
    }
}