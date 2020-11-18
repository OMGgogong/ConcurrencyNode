package com.hz.fh.concurrency.practice.part1.safe;
/**
 * 只有get方法不会出现线程安全问题
 * @author Administrator
 *
 */
public class SafeClass5 {
    private long count = 0;
    public SafeClass5(){
        //this.count = 1;必须要注释掉该行代码
    }
    //返回出去的只是count的视图
    public long getCount() {
        return count;
    }
    
    public static void main(String[] args) {
    	SafeClass5 sf5 = new SafeClass5();
    	long co = sf5.getCount();
    	System.out.println(sf5.getCount());//count=0
    	co = 2L;//sf5.getCount()发布出去的count是 SafeClass5内部属性的一个视图
    	System.out.println(sf5.getCount());//count=0
	}
}