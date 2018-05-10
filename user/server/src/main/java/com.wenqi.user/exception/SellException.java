package com.wenqi.user.exception;


import com.wenqi.user.enums.ResultEnum;

/**
 * @Author: 文琪
 * @Description: 系统自定义异常
 * @Date: Created in 2018/3/20 上午9:59
 * @Modified By:
 */

public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
