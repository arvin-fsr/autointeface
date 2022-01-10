package com.httpclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class myCookiesForPost {
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
    public void testPostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testurl = this.url + uri;
        //1、声明方法，2、声明Client对象，3、添加参数并添加到方法中，4、设置请求头信息，5、声明一个对象来进行响应结果的存储，
        // 6、设置cookies，7、执行post方法，8、获取响应结果并断言
        HttpPost post = new HttpPost(testurl);
        //CloseableHttpClient client = HttpClients.createDefault();
        JSONObject param = new JSONObject();
        param.put("name","wangwu");param.put("age","30");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        post.setHeader("content-type","application/json");
        String result;
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();
        CloseableHttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.print(statusCode +"   "+result);
        JSONObject resultjson = JSONObject.parseObject(result);
        String success=(String) resultjson.get("wangwu");
        Assert.assertEquals("Success",success);

    }
}