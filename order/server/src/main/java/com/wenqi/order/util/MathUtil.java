package com.wenqi.order.util;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/3/30 下午2:05
 * @Modified By:
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较两个数是否相等
     * @param d1
     * @param d2
     * @return Boolean
     */
    public static Boolean equals(Double d1, Double d2){
      Double result =  Math.abs(d1 - d2);
      return result < MONEY_RANGE ? true : false;
    }
}
