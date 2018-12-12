package com.example.demo.utils;

import com.example.demo.utils.LoggerUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {
    private static HttpClient httpclient = HttpClientBuilder.create().build();
    private static Logger logger = LoggerUtils.SYSTEM;

    /**
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
     */
//    public String post(String url,String respEncoding) {
//        return post(url,"UTF-8",respEncoding,new ArrayList<NameValuePair>());
//    }
    public static HttpResponse post(String url) {
        return post(url, "UTF-8", new ArrayList<NameValuePair>());
    }

    /**
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
     */
    public static HttpResponse post(String url, String reqEncoding, List<NameValuePair> param) {
        HttpResponse response = null;
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        // 创建参数队列
//        List<NameValuePair> formparams = param;
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(param, reqEncoding);
            httppost.setEntity(uefEntity);
            response = httpclient.execute(httppost);
//            HttpEntity entity = response.getEntity();
//            if (entity != null) {
//                resStr = EntityUtils.toString(entity,respEncoding);
//            }
        } catch (Exception e) {
            logger.error(e);
        } finally {
            // 关闭连接,释放资源
            // httpclient.getConnectionManager().shutdown();
        }
        return response;
    }

    /**
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
     */
    public static HttpResponse get(String url, List<NameValuePair> param) {
        HttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameters(param);
            URI uri = builder.build();
            System.out.println(uri);
            HttpGet httpget = new HttpGet(uri);
            response = httpclient.execute(httpget);
        } catch (Exception e) {
            logger.error(e);
        }
        return response;
    }


    /**
     * 发送 get请求
     */
    public String get(String url) {
        //httpclient = new DefaultHttpClient();
        String resStr = "";
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(url);
            // 执行get请求.
            HttpResponse response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                // 打印响应内容长度
//                System.out.println("Response content length: "
//                        + entity.getContentLength());
                // 打印响应内容
//                System.out.println("Response content: "
//                        + EntityUtils.toString(entity));
                resStr = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            logger.error(e);
        } finally {
            // 关闭连接,释放资源
            //httpclient.getConnectionManager().shutdown();
        }
        return resStr;
    }
    public static boolean checkResult(HttpEntity entity) throws ParseException, IOException {
        String data = EntityUtils.toString(entity, "gbk");
        System.out.println("result=" + data);
        boolean isSended = false;
        if (StringUtils.isNotBlank(data)) {
            String[] pairs = StringUtils.split(data, "&");
            if (pairs != null && pairs.length != 0) {
                String result = null;
                String descr = null;
                for (String pair : pairs) {
                    if (StringUtils.isNotBlank(pair)) {
                        String[] nameValue = StringUtils.split(pair, "=");
                        if (nameValue != null && nameValue.length == 2) {
                            String name = nameValue[0];
                            String value = nameValue[1];
                            if (StringUtils.equals(name, "result")) {
                                result = value;
                            } else if (StringUtils.equals(name, "description")) {
                                descr = value;
                            }
                        }
                    }
                }
                if (StringUtils.equals(result, "0")) {
                    isSended = true;
                } else {
                    logger.error("Sending Message Error. Code: " + result + ", Because : " + descr);
                }
            }
        }
        return isSended;
    }
}