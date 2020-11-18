package com.hz.fh.concurrency.practice.part1.safe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
//不可变类-变种--一定线程安全  不可被继承
public final class ImmutableOtherClass8 {
    //time1与time2没有任何约束条件
    public final long count;// 即使发布出去该属性也不可修改 --正常的不可变类属性
    private final List<Long> otherCountArray = new ArrayList<>();// private属性
    // otherCountArray通过Collections.unmodifiableList变种后仍然达到不可变的效果
    private final List<Long> unModifileotherCountArray = Collections.unmodifiableList(otherCountArray);
    private final Date time1;// Date是可变类、通过拷贝的方式赋值给time1，通过拷贝的形式发布出去。
    private final Date time2;// Date是可变类、通过拷贝的方式赋值给time2，通过拷贝的形式发布出去。
    public ImmutableOtherClass8 (long count, Date time1, Date time2) {
        this.count = count;
        this.time1 = new Date(time1.getTime());
        this.time2 = new Date(time2.getTime());
    }
    // 只允许count初始化一次 ，该类只有初始化后才可以被多个线程使用。该类只有读操作，即多个线程只能读不可修改。
    // 所以不可变类是线程安全的
    public long getCount() {
        return count;
    }
    public List<Long> getOtherCountArray() {
        return otherCountArray;
    }
    public List<Long> getUnModifileotherCountArray() {
        return unModifileotherCountArray;
    }
    public Date gettime1() {
        return new Date(time1.getTime());
    }
    public Date gettime2() {
        return new Date(time2.getTime());
    }

}