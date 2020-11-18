package com.hz.fh.concurrency.practice.part1.unsafe;
/**
 * 不安全的类-可见性导致的线程安全问题
 */
public class UnsafeClass0 {
    private long count = 0;//共享变量
    //一直使用cpu1执行a线程，a线程只调用get方法
    public long getCount(){return count;};
    //一直使用cpu2执行b线程，b线程只调用set方法
    public void setCount(long count){this.count = count;}
    //在b线程中set了10次，a线程才get出来。
}