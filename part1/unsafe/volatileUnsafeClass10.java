package com.hz.fh.concurrency.practice.part1.unsafe;
public class volatileUnsafeClass10 {
    /**
     * JMM规定两个线程通讯必须把数据放在主内存。
     * 这里使用volatile后 
     * set后cpu一定将数据放在主内存
     * get方法后cpu一定从主内存中读取
     */
    private  volatile long count;

    /**
     * 2019.10.30补
     * opt1和opt2不能保证原子性，尽管count使用volatile修饰
     * @param count
     */
    public void setCount2(long count) {
    	if(count==1){ //opt1
    		this.count = 3;//opt2
    	}
    }



}