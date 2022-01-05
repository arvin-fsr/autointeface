package com.couurse.testNG;

import org.testng.annotations.*;

public class BasicAnnotation {
    //基本注释，用来把方法标志为测试的一部分
    @Test
    public void testCase1(){
        System.out.print("这是测试1");
    }
    @Test
    public void testCase2(){
        System.out.print("这是测试2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.print("beforeMethod这是测试方法之前运行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.print("afterMethod这是测试方法之后运行");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是类运行之前运行的");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("afterClass这是类运行之后运行的");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite套件");
    }
}
