package com.wenqi.product.service.impl;


import com.wenqi.product.dao.ProductCategoryDao;
import com.wenqi.product.entity.ProductCategory;
import com.wenqi.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 文琪
 * @Description: 商品类目
 * @Date: Created in 2018/3/26 上午9:13
 * @Modified By:
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao categoryDao;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryDao.findByCategoryTypeIn(categoryTypeList);
    }

}
