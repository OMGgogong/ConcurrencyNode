package com.hz.fh.concurrency.practice.part1.safe;
public class volatileClass9 {
    /**
     * JMM规定两个线程通讯必须把数据放在主内存。
     * 这里使用volatile后 
     * set后cpu一定将数据放在主内存
     * get方法后cpu一定从主内存中读取
     */
    private  volatile long count;//线程安全的
    private  volatile Long countL;//仍然线程安全的、因为Long是线程安全的不可变类
    //从主内存获得值后放到工作内存中--不存在缓存
    public long getCount() {
        return count;
    }
    //从工作内存修改值后放到主内存中--不存在缓存
    public void setCount(long count) {
        this.count = count;
    }
    public Long getCountL() {
        return countL;
    }
    public void setCountL(Long countL) {
        this.countL = countL;
    }
}