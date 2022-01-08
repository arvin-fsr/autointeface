package com.couurse.testNG.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void serverTest1(){
        System.out.println("服务端测试用例1");
    }

    @Test(groups="server")
    public void serverTest2(){
        System.out.println("服务端测试用例2");
    }

    @Test(groups="client")
    public void clientTest1(){
        System.out.println("客户端测试用例1");
    }

    @Test(groups="client")
    public void clientTest2(){
        System.out.println("客户端测试用例2");
    }

    @BeforeGroups(groups = "client")
    public void beforeClientGroups(){
        System.out.println("---客户端组前置步骤---");
    }

    @AfterGroups(groups = "client")
    public void afterClientGroups(){
        System.out.println("---客户端组后置步骤---");
    }
    }