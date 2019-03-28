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
        String s = DateUtil.formatDate(nowDate);

        System.out.println(s);

    }

    @Test
    public void parseDate() {
    }
}