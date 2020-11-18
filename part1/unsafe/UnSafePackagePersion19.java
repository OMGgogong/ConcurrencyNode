package com.hz.fh.concurrency.practice.part1.unsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Administrator 实例封装
 */
public class UnSafePackagePersion19<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());
//使用的锁不是同一个、所以造成线程不安全
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }
}