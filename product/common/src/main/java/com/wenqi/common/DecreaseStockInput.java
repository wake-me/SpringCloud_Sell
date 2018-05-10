package com.wenqi.common;

import lombok.Data;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/11 下午3:51
 * @Modified By:
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
