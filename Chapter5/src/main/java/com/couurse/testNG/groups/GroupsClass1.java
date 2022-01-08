package com.couurse.testNG.groups;

import org.testng.annotations.Test;

@Test(groups="stu")
public class GroupsClass1 {

    public void stu1(){
        System.out.println("groupsonclass1--stu1");
    }
    public void stu2(){
        System.out.println("groupsonclass1--stu2");
    }
}
