package com.jumprabbit.common.data;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author tianbeiping
 * @Title: DateUtilTest
 * @ProjectName common-util
 * @Description:
 * @date 19/3/28下午6:36
 */
public class DateUtilTest {

    @Test
    public void formatDate() {

        Date nowDate = DateUtil.getNowDate();
        String s = DateUtil.format(nowDate);

        System.out.println(s);

        Date date = DateUtil.parse(s, DateUtil.yyyy_MM_dd_hh_mm_ss);

        System.out.println(date);


    }

    @Test
    public void parseDate() {
    }
}