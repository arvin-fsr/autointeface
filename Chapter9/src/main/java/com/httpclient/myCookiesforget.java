package com.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class myCookiesforget {

    private String url;
    private ResourceBundle bundle;

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
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.print(result);

    }
}
