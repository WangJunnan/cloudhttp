package com.sunshine.cloudhttp.util;

/**
 * StringUtils
 *
 * @author wangjn
 * @date 2019/4/10
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param s
     * @return
     */
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}
