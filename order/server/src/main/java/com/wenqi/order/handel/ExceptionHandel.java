package com.wenqi.order.handel;



import com.wenqi.order.enums.ResultEnum;
import com.wenqi.order.exception.SellException;
import com.wenqi.order.util.HttpResult;
import com.wenqi.order.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author: 文琪
 * @ Description: 异常统一处理
 * @ Date: Created in 2018/3/20 下午7:04
 * @ Modified By:
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandel {



    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult handel(Exception e) {
        if (e instanceof SellException) {
            SellException sellException = (SellException) e;
            return ResultUtil.error(sellException.getCode(), sellException.getMessage());
        } else {
            log.error("『系统异常』,{}", e.getMessage());
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMsg());

        }
    }


}
