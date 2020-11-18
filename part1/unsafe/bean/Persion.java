package com.hz.fh.concurrency.practice.part1.unsafe.bean;

public class Persion {
private int count;
private String name;
	public void setCount(int count) {
	this.count = count;
}
	public Persion(Persion p) {
	}
	public Persion(){
		
	}
	public Persion(String string) {
	}
	public int getCount() {
		return 0;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
