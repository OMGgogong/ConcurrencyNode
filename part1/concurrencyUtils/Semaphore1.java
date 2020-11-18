package com.hz.fh.concurrency.practice.part1.concurrencyUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * @author Administrator
 * 用来控制同时访问某个特定资源的操作数量，或者同时执行某个指定操作的数量
 */
public class Semaphore1<T> {
private final Set<T> set;
private final Semaphore sem;

/**
 * 
 * @param bound
 */
Semaphore1(int bound){
	this.set = Collections.synchronizedSet(new HashSet<T>());//使容器变得有界、JDK写好的有BlockingQueue
	sem = new Semaphore(bound);
}

public boolean add(T o) throws InterruptedException{
	sem.acquire();
	boolean wasAdded = false;
	try{
		wasAdded = set.add(o);
		return wasAdded;
	}finally{
		if(!wasAdded)
			sem.release();
	}
}

public boolean remove(Object o){
	boolean wasremoved = set.remove(o);
	if(wasremoved){
		sem.release();
	}
	return wasremoved;
}

	
	
}
