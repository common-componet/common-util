package com.jumprabbit.common.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;

/**
 * @author tianbeiping
 * @Title: HttpUtil
 * @ProjectName common-util
 * @Description:
 * @date 19/3/29上午10:49
 */
public class HttpUtil {

    private HttpUtil() {
        //工具类无需对象实例化
    }

    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";
    private static final String PUT_METHOD = "PUT";
    private static final String DELETE_METHOD = "DELETE";


    private static final int connect_timeout = 1000;
    private static final int read_timeout = 1000;


    public static String get(String urlPath) {
        return get(urlPath, null, read_timeout);
    }

    public static String get(String urlPath, int timeout) {
        return get(urlPath, null, timeout);
    }

    public static String get(String urlPath, Map<String, String> headMap) {
        return get(urlPath, headMap, read_timeout);
    }

    public static String get(String urlPath, Map<String, String> headMap, int timeout) {
        String data = null;
        InputStream inputStream = null;
        try {
            StringBuilder sb = new StringBuilder();
            if (Objects.nonNull(headMap) && headMap.size() > 0) {
                sb.append("?");
                Set<Map.Entry<String, String>> entries = headMap.entrySet();
                for (Map.Entry<String, String> entry : entries) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
                String substring = sb.substring(0, sb.length() - 1);
                urlPath += substring;
                sb = null;
            }
            URLConnection content = getContent(GET_METHOD, urlPath, null, null, timeout);
            if (Objects.isNull(content)) {
                return data;
            }
            data = IoUtil.toString(content.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(inputStream)) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static String post(String urlPath, String dataParam) {
        return post(urlPath, dataParam, "application/json;charset=UTF-8");
    }

    public static String post(String urlPath, String dataParam, String contentType) {
        return post(urlPath, dataParam, Collections.singletonMap("content-type", contentType));
    }

    public static String post(String urlPath, String dataParam, Map<String, String> headMap) {
        String result = null;
        InputStream inputStream = null;
        try {
            URLConnection content = getContent(POST_METHOD, urlPath, dataParam, headMap, read_timeout);
            if (Objects.isNull(content)) {
                return result;
            }
            result = IoUtil.toString(content.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(inputStream)) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private static URLConnection getContent(String method, String urlPath, String data, Map<String, String> headMap, int timeout) {

        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlPath);

            connection = (HttpURLConnection) url.openConnection();

            connection.setUseCaches(false);
            connection.setReadTimeout(timeout);
            connection.setConnectTimeout(connect_timeout);
            connection.setRequestMethod(method);
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "pplication/json, text/javascript, */*; q=0.01");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");

            if (Objects.nonNull(headMap)) {
                Set<Map.Entry<String, String>> entries = headMap.entrySet();
                for (Map.Entry<String, String> entry : entries) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if (!"GET".equals(method)) {
                // 发送POST请求必须设置如下两行
                connection.setDoOutput(true);
                connection.setDoInput(true);
                if (StringUtil.isNotBlank(data)) {
                    OutputStream outputStream = connection.getOutputStream();
                    PrintWriter writer = new PrintWriter(outputStream);
                    writer.write(data);
                    writer.flush();
                }
            } else {
                connection.connect();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }


    private static String proxyHttp() {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com");

            // 创建代理服务器
            InetSocketAddress addr = new InetSocketAddress("172.21.1.8", 80);
            // http 代理
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
            URLConnection conn = url.openConnection(proxy);
            //以下三行是在需要验证时，输入帐号密码信息
            String headerkey = "Proxy-Authorization";
            //帐号密码用:隔开，base64加密方式
            String headerValue = "Basic " + Base64.getEncoder().encode("atco:atco".getBytes());
            conn.setRequestProperty(headerkey, headerValue);
            InputStream in = conn.getInputStream();
            // InputStream in = url.openStream();
            String s = IoUtil.toString(in);

            return s;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
