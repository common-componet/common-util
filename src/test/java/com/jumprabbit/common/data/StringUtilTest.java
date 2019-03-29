package com.jumprabbit.common.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tianbeiping
 * @Title: StringUtilTest
 * @ProjectName common-util
 * @Description:
 * @date 19/3/29上午10:45
 */
public class StringUtilTest {

    @Test
    public void urldecode() {
    }

    @Test
    public void urlencode() {
    }

    @Test
    public void unicode() {

        String val = "哥特式建筑，122122";

        String unicode = StringUtil.unicode(val);

        System.out.println(unicode);

        String s = StringUtil.decodeUnicode(unicode);

        System.out.println(s);

    }

    @Test
    public void decodeUnicode() {


    }
}