package com.jumprabbit.common.data;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author tianbeiping
 * @Title: HttpUtilTest
 * @ProjectName common-util
 * @Description:
 * @date 19/3/29上午11:24
 */
public class HttpUtilTest {

    @Test
    public void get() {

        Map<String, String> data = new HashMap<>();
        data.put("name", "tian");
        String s = HttpUtil.get("http://c.pd.test.cn/services/customer/ping", data);

        System.out.println(s);

        String s1 = HttpUtil.post("http://c.pd.test.cn/services/customer/queueDetail", "{\"shopId\":\"305304\"}");

        System.out.println(s1);

    }
}