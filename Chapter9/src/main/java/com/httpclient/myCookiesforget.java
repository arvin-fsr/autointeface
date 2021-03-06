package com.httpclient;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class myCookiesforget {
    private String url;
    private ResourceBundle bundle;
    private BasicCookieStore store;
    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetcookies() throws IOException {
        String result;
        //拼接URL
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url + uri;
        HttpGet get = new HttpGet(testurl);
        /////BasicCookieStore store = new BasicCookieStore();
        this.store = new BasicCookieStore();
        //CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
        CloseableHttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //获取cookies信息
        //BasicCookieStore store = new BasicCookieStore();
        //store = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).build();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.print(name+"="+value);
        }
    }
    @Test(dependsOnMethods = {"testGetcookies"})
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testurl = this.url + uri;
        HttpGet get = new HttpGet(testurl);
        //设置cookies信息
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();
        CloseableHttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.print(statusCode +"   "+EntityUtils.toString(response.getEntity()));
    }
}
