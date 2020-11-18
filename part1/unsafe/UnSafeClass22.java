package com.hz.fh.concurrency.practice.part1.unsafe;
/**
 * 存在该类没有被完全初始化完成，就被引用后使用。会导致引用该类的线程的count一定时间内看到的count是0。
 * 有线程安全问题
 * @author Administrator
 *
 */
public class UnSafeClass22 {
    private long count = 0;
    public UnSafeClass22(){
        this.count = 1;//比UnSafeClass5类多该句
    }
    public long getCount() {
        return count;
    }
}