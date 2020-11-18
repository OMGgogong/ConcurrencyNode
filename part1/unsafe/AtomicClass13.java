package com.hz.fh.concurrency.practice.part1.unsafe;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicClass13 {
    /**
     * 2020.11.16日再看表示惊讶。这里基础薄弱
     */
    private   AtomicLong count; //同样是多线程缓存问题、这种写法会产生线程安全
    //从主内存获得值后放到工作内存中--该方法存在缓存在寄存器和其他cpu看不见的地方的可能
    //方法一写法
    public AtomicLong getCount() {
        return count;
    }
    //从工作内存修改值后放到主内存中--该方法存在缓存在寄存器和其他cpu看不见的地方的可能
    //方法二写法
    public void setCount(AtomicLong count) {
        this.count = count;
    }
    /**
     * 也许上面的get与set方法就不应该出现在AtomicClass13中
     * 真正委托的用途是
     * 
     public void setLong(long l){
        count.set(l);
     }
     public long getLong(){
        return count.get();
     }
     * 
     * 但，即使使用正确的委托，只要是保留上述方法一二那种写法，就不是线程安全的。count的地址可见性存在问题
     */
}