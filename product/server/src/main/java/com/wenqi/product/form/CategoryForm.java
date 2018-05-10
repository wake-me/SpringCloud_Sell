package com.wenqi.product.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/4/2 下午1:23
 * @Modified By:
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**
     * 类目名称.
     */
    @NotBlank(message = "类目名称不能为空")
    private String categoryName;

    /**
     * 类目类型.
     */
    private Integer categoryType;
}
