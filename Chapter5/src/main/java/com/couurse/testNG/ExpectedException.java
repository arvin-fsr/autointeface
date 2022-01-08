package com.couurse.testNG;

import org.testng.annotations.Test;

public class ExpectedException {
    //异常测试：期望结果为某一个异常的时候

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFail(){
        System.out.println("异常测试1");

    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("异常测试2");
        throw new RuntimeException();


    }
}
