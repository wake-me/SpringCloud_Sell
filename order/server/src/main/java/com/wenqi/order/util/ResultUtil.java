package com.wenqi.order.util;

/**
 * @ Author: 文琪
 * @ Description: 返回结果
 * @ Date: Created in 2018/3/21 下午3:07
 * @ Modified By:
 */
public class ResultUtil {

    public static HttpResult success(Object object) {
        HttpResult result = new HttpResult();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static HttpResult success() {
        return success(null);
    }

    public static HttpResult error(Integer code, String msg) {
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
