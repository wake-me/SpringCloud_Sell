package com.wenqi.product.dao;

import com.wenqi.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/3/19 下午4:01
 * @Modified By:
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
