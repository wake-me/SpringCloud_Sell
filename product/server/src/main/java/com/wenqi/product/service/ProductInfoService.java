package com.wenqi.product.service;

import com.wenqi.common.DecreaseStockInput;
import com.wenqi.common.ProductInfoOutput;
import com.wenqi.product.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ Author: 文琪
 * @ Description: 商品详情
 * @ Date: Created in 2018/3/26 上午9:58
 * @ Modified By:
 */
public interface ProductInfoService {

//    ProductInfo findOne(String productId);

    /**
     * 查询在架商品
     *
     * @return List<ProductInfo>
     */
    List<ProductInfo> findUpAll();


//
//    Page<ProductInfo> findAll(Pageable pageable);


    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);


//    ProductInfo save(ProductInfo productInfo);

    // 加库存
//    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<DecreaseStockInput> cartDTOList);

//    //上架
//    ProductInfo onSale(String productId);
//
//    //下架
//    ProductInfo offSale(String productId);
}
