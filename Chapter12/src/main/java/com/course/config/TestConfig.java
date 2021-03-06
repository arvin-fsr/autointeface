package com.course.config;

import lombok.Data;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;


@Data
public class TestConfig {

    //登陆接口uri
    public static String loginUrl;
    //更新用户信息接口uri
    public static String updateUserInfoUrl;
    //获取用户列表接口uri
    public static String getUserListUrl;
    //获取用户信息接口uri
    public static String getUserInfoUrl;
    //添加用户信息接口
    public static String addUserUrl;


    //用来存储cookies信息的变量
    public static BasicCookieStore store;
    //声明http客户端
    public static CloseableHttpClient httpClient;
    //public static HttpClient httpClient;

}
