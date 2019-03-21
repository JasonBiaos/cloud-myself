package com.hhsoft.cloud.commons.utils.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: PhoneUtil
 * @Description 手机号码校验工具类
 * @Author Jason Biao
 * @Date 2019/3/21 14:27
 * @Version 1.0
 **/
public class PhoneUtil {

    /**
     * 正则表达式（）
     */
    private static String REGEX = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
    private static Pattern P = Pattern.compile(REGEX);

    /**
     * 校验手机号
     *
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return Boolean.FALSE;
        }

        Matcher m = P.matcher(phone);
        return m.matches();
    }
}
