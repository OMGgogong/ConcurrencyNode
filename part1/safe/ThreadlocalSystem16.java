package com.hz.fh.concurrency.practice.part1.safe;

import com.hz.fh.concurrency.practice.part1.unsafe.bean.Persion;

/**
 * 
 * @author Administrator
 *  使用线程封闭技术可以解决线程安全问题，也可以用作在统一事务管理中。2020.11.16日补
 */
public class ThreadlocalSystem16 {
    //使用线程封闭技术
    private static final ThreadLocal<Persion> persionHolder = new ThreadLocal<Persion>(){
         protected Persion initialValue() {
             return new Persion();
         };
    };
    /**
     * Persion会被封装到线程中所以不会造成线程安全问题，确切的说"避免了线程共享"
     * 
     */
    public void setPersion(Persion p){
        persionHolder.set(p);
    }
    public Persion getPersion(){
        return persionHolder.get();
    }
    /**
     *  该类中加入该方法、会造成persionHolder这个属性发布出去
     *  一个线程读取、一个线程写会造成persionHolder这个属性产生线程安全
     *
        public ThreadLocal<Persion> getPersionHolder() {
            return persionHolder;
        }
        public void setPersionHolder(ThreadLocal<Persion> persionHolder) {
            this.persionHolder = persionHolder;
        }
     * 
     */
    public static void main(String[] args) {
    	ThreadlocalSystem16 ccc = new ThreadlocalSystem16();
        //一个线程对ccc执行getPersionHolder
        //另一个线程对ccc执行setPersionHolder
        boolean flag = true;
        while (true) {
            //线程一旦启动，永不结束
            if(flag){
                persionHolder.set(new Persion("张三"));
                flag = false;
            }
            //...省略
            if(!flag){
                persionHolder.set(null);//不再存储任何数据、之前存储的  Persion("张三")会被回收
            }
        }
    }
}