package com.extentReport;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void logDemo(){
        Reporter.log("log1111111111");
        throw new RuntimeException("xianshi-yichang");
    }
}
