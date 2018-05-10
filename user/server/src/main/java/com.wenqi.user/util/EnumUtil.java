package com.wenqi.user.util;


import com.wenqi.user.enums.CodeEnum;

/**
 * @Author: 文琪
 * @Description:
 * @Date: Created in 2018/3/30 下午3:54
 * @Modified By:
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){
        for (T each: enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
