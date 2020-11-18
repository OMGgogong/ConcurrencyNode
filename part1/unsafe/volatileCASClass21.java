package com.hz.fh.concurrency.practice.part1.unsafe;

/**
 * 同样不是线程安全的
 * 这里出现了复合操作
 */
public class volatileCASClass21 {

    private  volatile int state = 0;
 
    private static final int NEW = 0 ;
    private static final int COMMING = 1 ;
    private static final int DONE = 2 ;
    public void setCount(long count) {
    	if(UNSAFE.compareAndSwapInt(this, stateOffset, NEW,COMMING)){
    		//state = 1;
    		UNSAFE.compareAndSwapInt(this, stateOffset, COMMING,DONE);
    	}   
    	//UNSAFE.compareAndSwapInt(this, stateOffset, 0,1);
    }
    private static final sun.misc.Unsafe UNSAFE;
    private static final long stateOffset;

    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = volatileCASClass21.class;
            stateOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("state"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}