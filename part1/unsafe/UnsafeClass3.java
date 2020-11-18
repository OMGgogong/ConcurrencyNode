package com.hz.fh.concurrency.practice.part1.unsafe;
/**
 * 变种3--实际且经常写的一个类
 * get与set隐藏的很深
 */
public class UnsafeClass3 {
    public long count = 0;//public 属性、默认开放了set与get方法
}