package com.jumprabbit.common.data;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author tianbeiping
 * @Title: DateUtil
 * @ProjectName common-util
 * @Description:
 * @date 19/3/28下午6:14
 */
public class DateUtil {

    private DateUtil() {
    }


    public final static String yyyy_MM_dd_hh_mm_ss = "yyyy-MM-dd HH:mm:ss";

    public final static String yyyyMMddhhmmss = "yyyyMMddHHmmss";

    public final static String yyyy_MM_dd = "yyyy-MM-dd";

    public final static String hh_mm_ss = "HH:mm:ss";

    public final static ZoneOffset zoneOffset = ZoneOffset.of("+8");

    public static DateTimeFormatter getFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    public static LocalDateTime getNowLocalDate() {
        return LocalDateTime.now(ZoneId.systemDefault());
    }

    public static Date getNowDate() {
        return Date.from(getNowLocalDate().toInstant(zoneOffset));
    }

    public static LocalDateTime getDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date getDate(LocalDateTime date) {
        return Date.from(date.toInstant(zoneOffset));
    }

    public static String format() {
        return format(getNowDate(), yyyy_MM_dd_hh_mm_ss);
    }

    public static String format(Date currentDate) {
        return format(currentDate, yyyy_MM_dd_hh_mm_ss);
    }

    public static String format(Date currentDate, String format) {
        return getFormatter(format).format(getDate(currentDate));
    }

    public static Date parse(String stringDate) {
        return getDate(LocalDateTime.from(getFormatter(yyyy_MM_dd_hh_mm_ss).parse(stringDate)));
    }

    public static Date parse(String stringDate, String format) {
        return getDate(LocalDateTime.from(getFormatter(format).parse(stringDate)));
    }

}
