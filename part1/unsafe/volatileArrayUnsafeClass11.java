package com.hz.fh.concurrency.practice.part1.unsafe;
public class volatileArrayUnsafeClass11 {
    /**
     * 不光要了解volatile的特性、也要了解作用在哪个位置
     */

    //volatile只对数据的引用保持可见性、而不是他的元素
    private  volatile long[] countArray; 

    public long[] getCountArray() {
        return countArray;
    }
    public void setCountArray(long[] countArray) {
        this.countArray = countArray;
    }
}