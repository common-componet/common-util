package com.jumprabbit.common.data;

import java.io.*;

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

    public static String toString(InputStream inputStream) {

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        return toString(reader);
    }

    public static String toString(Reader reader) {

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
