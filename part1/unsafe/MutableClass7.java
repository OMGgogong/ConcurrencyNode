package com.hz.fh.concurrency.practice.part1.unsafe;

import com.hz.fh.concurrency.practice.part1.unsafe.bean.Persion;

/**
 * 
 * @author Administrator
 * 一个类A即使全都是用final修饰的属性也不一定是线程安全的、只有当属性是线程安全的类时候该类A才是线程安全的。（数组除外）
 * 一个类A有数组属性、不管使用不使用final修饰都不是线程安全的、final只是确保引用不能确保元素。
 */
public class MutableClass7 {
    public long otherCount = 0;// public属性 不安全 
    // public属性 otherCountArray引用是安全的，但引用值可以更改、不安全
    //要使otherCountArray的值不可更改 可以Collections.unmodifiableList
    // 
    /**
     * public属性 otherCountArray引用是安全的，但引用值可以更改、不安全。倘若要使otherCountArray的值也不可更改 
     * 
     * 1. 可使用Collections.unmodifiableList 限定不可更改里面的值做到安全
     * 像Collections.unmodifiableList功能的还有Collections.unmodifiableMap(m)、
     * Collections.unmodifiableSet(s)、Collections.unmodifiableSortedMap(m)
     * Collections.unmodifiableSortedSet(s)、Collections.unmodifiableNavigableMap(arg0)、
     * Collections.unmodifiableNavigableSet(arg0)、Collections.unmodifiableCollection(c)
     * 2. 深拷贝一份发布出去。发布出去的数据不管外部如何修改，均并不会影响未源数据
     * 通过以上两种操作后otherCountArray属性也变成不可变的了
     */
    public final long[] otherCountArray = new long[10];//public属性 线程不安全
    public final long count;// 安全的
    public final Long countL;// 安全的
    private final Persion p; //线程不安全
    public MutableClass7(long count) {
        this.count = count;
        this.countL = new Long(0);
        this.p = new Persion();
    }
    public void service(){
        otherCountArray[0] = 100;//但引用值可以更改、不安全
       // Collections.unmodifiableList(Longs.asList(otherCountArray));
    }
    public Persion getP() {
        return p;
    }
}