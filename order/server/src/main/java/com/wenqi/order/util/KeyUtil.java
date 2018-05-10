package com.wenqi.order.util;

import java.util.Random;

/**
 * @ Author: 文琪
 * @ Description: 索引、可以 生成工具类
 * @ Date: Created in 2018/1/15 下午10:24
 * @ Modified By:
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     *
     * @return String
     */
    public static synchronized String genUniqueKey() {

        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
