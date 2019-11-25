package com.dj.thread.imutablility;

public class ImmutableValue {
	// 该对象的成员变量是安全的，因为它的值是不变的，在初始化时被赋予了值，并且只能获取该值不能修改
	private int value = 0;
	public ImmutableValue(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	// 如果要改变成员变量的值，则可以返回一个新对象
	public ImmutableValue add(int valueToAdd) {
		return new ImmutableValue(this.value + valueToAdd);
	}
	
}
