package com.hz.fh.concurrency.practice.part1.safe;
//不可变类--一定线程安全  不可被继承
public final class ImmutableClass6 {
    public final long count;// 即使发布出去该属性也不可修改
    public ImmutableClass6 (long count) {
        this.count = count;
    }
    // 只允许count初始化一次 ，该类只有初始化后才可以被多个线程使用。该类只有读操作，即多个线程只能读不可修改。
    // 所以不可变类是线程安全的
    public static void main(String[] args) {
    	ImmutableClass6 tenNum = new ImmutableClass6(10);
        // tenNum.count = 100;//这一步单线程中就会报错，更不用说多线程
    }
}