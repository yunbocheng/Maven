package com.yunbocheng;

import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {
    @Test
    public void testAdd(){
        System.out.println("测试方法执行1");
        HelloMaven hello = new HelloMaven();
        int res = hello.add(1, 2);
        // 判断结果是否正确
        Assert.assertEquals(3,res);
    }
    @Test
    public void testAdd2(){
        System.out.println("测试方法执行2");
        HelloMaven hello = new HelloMaven();
        int res = hello.add(1, 2);
        // 判断结果是否正确
        Assert.assertEquals(3,res);
    }
}
