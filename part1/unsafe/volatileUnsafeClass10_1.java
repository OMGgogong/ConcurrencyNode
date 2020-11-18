package com.hz.fh.concurrency.practice.part1.unsafe;

/**
 * 2020.11.16日补
 * 线程安全的定义
 */
public class volatileUnsafeClass10_1 {
    //约束条件是：min永远小于max
    private  volatile long min;
    private  volatile long max;

    //尽管使用了volatile关键字、虽然内存可见性解决了，但是该类仍然是不安全的。因为min与max存在约束条件。
    //一个类是否安全定义为是否破坏了约束条件
    public long getMax() {
        return max;
    }

    public long getMin() {
        return min;
    }
    //当一个线程设置min数据5、另一个线程设置max设置为4。但是min大于了max。所以破坏了类的约束条件，仍然表现的不安全。
    public void setMax(long max) {
        this.max = max;
    }

    public void setMin(long min) {
        this.min = min;
    }


}