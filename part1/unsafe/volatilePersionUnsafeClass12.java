package com.hz.fh.concurrency.practice.part1.unsafe;

import com.hz.fh.concurrency.practice.part1.unsafe.bean.Persion;

public class volatilePersionUnsafeClass12 {
    /**
     * 不光要了解volatile的特性、也要了解作用在哪个位置
     */
    private  volatile Persion p;
    public Persion getP() {
        return p;
    }
    public void setP(Persion p) {
        this.p = p;
    }
    //persion里面的name变化其他线程可能读到也可能读不到，因为Persion不是线程安全的
}