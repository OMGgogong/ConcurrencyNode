package com.hz.fh.concurrency.practice.part1.safe;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicSafeClass14 {
    private final AtomicLong count; // 使用final确保该类是不可变类、但该类中元素无法受到约束
    public AtomicSafeClass14(AtomicLong count) {
        this.count = count;
    }
    public AtomicLong getCount() {
        return count;
    }
    public void incrementAndGet() {
        count.incrementAndGet();// 该操作是原子操作、底层通过CAS实现的。不断轮询直到更新成功。--很多时间处于忙等状态。
    }
    /**
     * 这个才叫委托给Atomic类
     * 
     * @param l
     */
    public void setLong(long l) {
        count.set(l);
    }
    public long getLong() {
        return count.get();
    }
    /**
     * 该方法仍然会出现线程安全问题-因为两个原子操作不能合并成一个原子操作、仍然有线程安全的隐患 public void
     * unsafeMethod(){ if(count.get() == 100){ count.set(200); } }
     **/
    // 综上：判断该类是否是线程安全的需要根据发布的方法是否有隐患来判断、单纯的使用AtomicLong并不代表一定是线程安全的
}