package com.wenqi.product.service;



import com.wenqi.product.entity.ProductCategory;

import java.util.List;

/**
 * @ Author: 文琪
 * @ Description: 商品类目
 * @ Date: Created in 2018/3/26 上午9:09
 * @ Modified By:
 */
public interface ProductCategoryService {



    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


}
