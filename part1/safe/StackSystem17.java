package com.hz.fh.concurrency.practice.part1.safe;

import com.hz.fh.concurrency.practice.part1.unsafe.bean.Persion;

public class StackSystem17 {
    //使用栈封闭技术
    public void service(){
        Persion p = new Persion();
        //虽然出现了"竟态条件"但是仍然是线程安全的
        if(p.getCount() == 100){
            p.setCount(500);
        }
    }
}