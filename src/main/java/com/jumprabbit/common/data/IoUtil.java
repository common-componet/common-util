package com.jumprabbit.common.data;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author tianbeiping
 * @Title: IoUtil
 * @ProjectName common-util
 * @Description:
 * @date 19/3/29上午11:13
 */
public class IoUtil {

    private IoUtil() {
    }

    public static String getString(InputStream inputStream) {

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        return getString(reader);
    }

    public static String getString(Reader reader) {

        BufferedReader readers = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        try {
            String line;
            while ((line = readers.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
