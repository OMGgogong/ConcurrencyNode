package com.hz.fh.concurrency.practice.part1.safeOrUnsafe;

import java.util.Vector;
//同步容器类
public class SpecialClass20<E>{
private Vector<E> v = new Vector<>();
//Vector实现了List接口，所有的Vector方法都有syschronized关键词修饰，但是对于复合操作，Vector仍然是需要进行同步处理的
//像Vector这种同步容器类还有Hashtable等。
//既可以说Vector是线程安全、也可以说他不安全。
//完全线程安全的容器类应该是CopyOnWriteArrayList和ConcurrentHashMap

/**
 * 所有安全类中都要警惕 复合操作!
 */
}
