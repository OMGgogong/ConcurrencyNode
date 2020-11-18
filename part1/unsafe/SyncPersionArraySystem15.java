package com.hz.fh.concurrency.practice.part1.unsafe;

import java.util.Arrays;

import com.hz.fh.concurrency.practice.part1.unsafe.bean.Persion;

/**
 * 线程安全不安全主要看业务了，这里不能强制定义为线程不安全！！！日期：2020.11.16日补
 * 同步的persion
 * 加入synchronized一定是线程安全的吗？还需要进一步保证线程安全
 */
public class SyncPersionArraySystem15 {
    private  Persion[] ps = new Persion[10];
    private final Object lock = new Object();
    //加synchronized保证Persion[]被修改与读取时候是线程安全的 
    //使用Arrays.copyOf保证发布到外部的Persion数组里面的元素被修改均不会影响PersionArraySystem的安全性
    public Persion[] getPs(){
        synchronized (lock) {
            if(ps.length<10){
                ps = new Persion[10];
            }//这里获取了ps的值、同时又设置了ps的值。在synchronized块中是一个原子操作，但是发布出去了就造成了线程安全问题
        	return ps;//没有使用Arrays.copyOf导致将Persion数组发布出去、造成线程不安全
            //return Arrays.copyOf(ps, ps.length);
        }
    }
    //加synchronized保证Persion[]被修改与读取时候是线程安全的 
    //使用new Persion(p)保证外部的Persion修改不会影响PersionArraySystem的安全性
    public void setPs(int index,Persion p){
        synchronized (lock) {
            this.ps[index] = new Persion(p);
        }
    }
}