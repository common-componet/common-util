package com.jumprabbit.common.data;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

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

        Date date = DateUtil.parse(s, DateUtil.yyyy_MM_dd_HH_mm_ss);

        System.out.println(date);


    }

    @Test
    public void parseDate() {

        String s = UUID.randomUUID().toString();

        System.out.println(s);

        for (int i = 0; i < 100000; i++) {
            System.out.println(System.currentTimeMillis());
            System.out.println(System.nanoTime());
            System.out.println(LocalDateTime.now().getNano());
            System.out.println("============================");
        }

    }
}