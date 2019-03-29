package com.jumprabbit.common.data;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * @author tianbeiping
 * @Title: StringUtil
 * @ProjectName common-util
 * @Description:
 * @date 19/3/29上午10:34
 */
public class StringUtil {


    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isBlank(String str) {
        if (null == str || "".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    public static boolean isNull(String str) {
        if (null == str) {
            return true;
        }
        return false;
    }

    public static String getString(Object obj) {
        if (Objects.isNull(obj)) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static String urldecode(String src) {
        if (src == null) {
            return "";
        }
        try {
            return java.net.URLDecoder.decode(src, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return src;
    }

    public static String urlencode(String src) {
        if (src == null) {
            return "";
        }
        try {
            return java.net.URLEncoder.encode(src, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return src;
    }

    public static String unicode(String source) {
        StringBuffer sb = new StringBuffer();
        char[] source_char = source.toCharArray();
        String unicode;
        for (int i = 0; i < source_char.length; i++) {
            unicode = Integer.toHexString(source_char[i]);
            if (unicode.length() <= 2) {
                unicode = "00" + unicode;
            }
            sb.append("\\u" + unicode);
        }
        return sb.toString();
    }

    public static String decodeUnicode(String unicode) {
        StringBuffer sb = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            sb.append((char) data);
        }
        return sb.toString();
    }

}
