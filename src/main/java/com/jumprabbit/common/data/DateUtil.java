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


    private final static String yyyy_MM_dd_hh_mm_ss = "yyyy-MM-dd hh:mm:ss";

    private final static String yyyyMMddhhmmss = "yyyyMMddhhmmss";

    private final static String yyyy_MM_dd = "yyyy-MM-dd";

    private final static String hh_mm_ss = "hh:mm:ss";


    public static Date getNowDate() {
        return Date.from(LocalDateTime.now(ZoneId.systemDefault()).toInstant(ZoneOffset.of("+8")));
    }

    public static String formatDate(Date currentDate) {
        return DateTimeFormatter.ofPattern(yyyy_MM_dd_hh_mm_ss).format(currentDate.toInstant().atZone(ZoneId.systemDefault()));
    }


    public static Date parseDate(String stringDate, Date currentDate) {

        return null;
    }

}
