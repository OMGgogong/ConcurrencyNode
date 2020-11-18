package com.hz.fh.concurrency.practice.part1.safe;

import com.hz.fh.concurrency.practice.part1.unsafe.bean.Persion;

/**
 * 
 * @author Administrator
 *  实例封装 又叫 锁监控 在java并发包中经常使用该类技术
 *
 */
public class SafePackagePersion18 extends Persion{
    @Override
    public int getCount() {
        synchronized(this){
            return super.getCount();
        }
    }
    @Override
    public String getName() {
    synchronized(this){ return super.getName();}
    }
    @Override
    public void setCount(int count) {
    synchronized(this){     super.setCount(count);}
    }
    @Override
    public void setName(String name) {
    synchronized(this){ super.setName(name);}
    }
    //其他方法 使用的是persion的锁
    public void otherMethed() {
        synchronized(this){ 
            super.setName("sss");
        }
    }
}