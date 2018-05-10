package com.wenqi.product.service.impl;


import com.rabbitmq.tools.json.JSONUtil;
import com.wenqi.common.DecreaseStockInput;
import com.wenqi.common.ProductInfoOutput;
import com.wenqi.product.dao.ProductInfoDao;
import com.wenqi.product.entity.ProductInfo;
import com.wenqi.product.enums.ProductStatusEnum;
import com.wenqi.product.enums.ResultEnum;
import com.wenqi.product.exception.SellException;
import com.wenqi.product.service.ProductInfoService;
import com.wenqi.product.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ Author: 文琪
 * @ Description: 商品详情
 * @ Date: Created in 2018/3/26 上午10:02
 * @ Modified By:
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "product")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao infoDao;

    @Autowired
    private AmqpTemplate amqpTemplate;
//    /**
//     * 根据ID查询商品详情
//     * @param productId
//     * @return
//     */
//    @Override
//    public ProductInfo findOne(String productId) {
//        Optional<ProductInfo> optionalInfo = infoDao.findById(productId);
//        if (optionalInfo.isPresent())
//            return optionalInfo.get();
//
//        return null;
//    }

    /**
     * 查询在架所有商品
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {

        return infoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {


        return infoDao.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());

    }

//    /**
//     * 分页查询所有商品
//     * @param pageable
//     * @return
//     */
//    @Override
//    public Page<ProductInfo> findAll(Pageable pageable) {
//        return infoDao.findAll(pageable);
//    }

//    /**
//     * 新增商品
//     * @param productInfo
//     * @return
//     */
//    @Override
//    @CachePut(key = "123")
//    public ProductInfo save(ProductInfo productInfo) {
//        return infoDao.save(productInfo);
//    }


//    /**
//     * 增加库存
//     * @param cartDTOList
//     */
//    @Override
//    @Transactional
//    public void increaseStock(List<CartDTO> cartDTOList) {
//        for (CartDTO item : cartDTOList) {
//            Optional<ProductInfo> optionalInfo = infoDao.findById(item.getProductId());
//            if (!optionalInfo.isPresent()) {
//                log.error("【添加库存】商品不存在 productId={}", item.getProductId());
//                throw new ISellException(ResultEnum.PRODUCT_NOT_EXIST);
//            }
//            Integer productStock = optionalInfo.get().getProductStock() + item.getProductQuantity();
//            optionalInfo.get().setProductStock(productStock);
//
//            infoDao.save(optionalInfo.get());
//        }
//
//    }

    /**
     * 减少库存
     *
     * @param decreaseStockInputList
     */
    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);

        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e, productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());

        // 发送MQ消息
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutputList));

    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (DecreaseStockInput item : decreaseStockInputList) {
            Optional<ProductInfo> optionalInfo = infoDao.findById(item.getProductId());
            if (!optionalInfo.isPresent()) {
                log.error("【减库存】商品不存在 productId= {}", item.getProductId());
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = optionalInfo.get().getProductStock() - item.getProductQuantity();
            if (result < 0) {
                log.error("【减库存】商品库存不够 productId={},productQuantity={},productStock={}",
                        item.getProductId(), item.getProductQuantity(), optionalInfo.get().getProductStock());
            }
            optionalInfo.get().setProductStock(result);

            infoDao.save(optionalInfo.get());
            productInfoList.add(optionalInfo.get());
        }
        return productInfoList;
    }
//    /**
//     * 商品上架
//     * @param productId
//     * @return
//     */
//    @Override
//    public ProductInfo onSale(String productId) {
//        Optional<ProductInfo> info = infoDao.findById(productId);
//        if (!info.isPresent()){
//            log.error("【商品上架】 商品不存在, productId={}",productId);
//            throw new ISellException(ResultEnum.PRODUCT_NOT_EXIST);
//        }
//        if (info.get().getProductStatus().equals(ProductStatusEnum.UP.getCode())){
//            log.error("【商品上架】商品是在架状态");
//            throw new ISellException(ResultEnum.PRODUCT_STATUS_ERROR);
//        }
//        info.get().setProductStatus(ProductStatusEnum.UP.getCode());
//        ProductInfo updateResult = infoDao.save(info.get());
//        return updateResult;
//    }

//    /**
//     * 商品下架
//     * @param productId
//     * @return
//     */
//    @Override
//    public ProductInfo offSale(String productId) {
//        Optional<ProductInfo> info = infoDao.findById(productId);
//        if (!info.isPresent()) {
//            log.error("【商品下架】 商品不存在, productId={}", productId);
//            throw new ISellException(ResultEnum.PRODUCT_NOT_EXIST);
//        }
//        if (info.get().getProductStatus().equals(ProductStatusEnum.DOWN.getCode())) {
//            log.error("【商品下架】商品是下架状态");
//            throw new ISellException(ResultEnum.PRODUCT_STATUS_ERROR);
//        }
//        info.get().setProductStatus(ProductStatusEnum.DOWN.getCode());
//        ProductInfo updateResult = infoDao.save(info.get());
//        return updateResult
//
//    }

}
