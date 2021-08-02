package com.yunbocheng;

public class HelloMaven {
    public int add(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        HelloMaven hello = new HelloMaven();
        int res = hello.add(1, 2);
        System.out.println("1+2 = " + res);
    }
}
