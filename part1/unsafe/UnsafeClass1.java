package com.hz.fh.concurrency.practice.part1.unsafe;
/**
 * 变种1--实际且经常写的一个类
 * get与set隐藏的很深
 */
public class UnsafeClass1 {
    private long count = 0;//共享变量
    //虽然没有直接get、但是类似 get方法
    public long methed1(){
          long mycount = count;
          return mycount = (long) (mycount/3.0);
        };
    //虽然没有直接set、但是类似set方法
    public void methed2(long a){
            long c = a +50;
            this.count = c;
         }
}