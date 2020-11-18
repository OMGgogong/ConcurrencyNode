package com.hz.fh.concurrency.practice.part1.safe;
public class SafeClass4 {
    //count不是共享变量、而是局部变量，即使有get和set也是线程安全的。
    public void methed1(long a){
            long count = 0;
            long c = count + a;
            count = c;
         }
}