package com.wenqi.order.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @ Author: 文琪
 * @ Description:
 * @ Date: Created in 2018/3/21 下午3:04
 * @ Modified By:
 */
@Data
public class HttpResult<T>  implements Serializable {

    private static final long serialVersionUID = -4423326975924060605L;

    private Integer code;

    private String msg;

    private T data;
}
