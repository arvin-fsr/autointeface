package com.couurse.testNG.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class suiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.print("before suite!!!!");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.print("afterSuite!!!");
    }
    @BeforeTest
    public void brforetest(){
        System.out.print("beforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.print("afterTset");
    }
}
