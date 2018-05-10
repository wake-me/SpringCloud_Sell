package com.wenqi.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ Author: 文琪
 * @ Description: 商品(包含类目)
 * @ Date: Created in 2018/3/26 下午12:46
 * @ Modified By:
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -410087485546079015L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
