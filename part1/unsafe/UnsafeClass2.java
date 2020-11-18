package com.hz.fh.concurrency.practice.part1.unsafe;
/**
 * 变种2--实际且经常写的一个类
 * get与set隐藏的很深
 */
public class UnsafeClass2 {
    private long count = 0;//共享变量
    //虽然没有直接set和get、但是类似set方法和get方法
    //A线程设置count的值B线程同样看不到
    public void methed1(long a){
            long c = count + a;
            this.count = c;
         }
         //上边类似的方法-又一个变种
         //public void methed2(long a){
         //   long c = getCount() + a;
         //   setCount(c);
        // }
}