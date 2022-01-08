package com.couurse.testNG.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testdataprovider(String name,int age){
        System.out.println("name="+ name + " ; age="+ age);
    }
    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o=new Object[][]{
                {"zhangsan",10},
                {"lisi",12},
                {"wangwu",15}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1-"+name+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test1-"+name+age);
    }
    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result =new Object[][]{
                    {"zhangsan",20}
            };
        }else if(method.getName().equals("test2"))
            result = new Object[][]{
                    {"lisi",30}
            };
        return result;
    }

}
