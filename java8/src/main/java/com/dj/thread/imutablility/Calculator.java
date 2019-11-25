package com.dj.thread.imutablility;

public class Calculator {
	// 引用了一个不可变的类，但是却是线程不安全的,因为 ImmutableValue 的值可以通过本类的方法去更改它的引用导致 ImmutableValue 的 value 值发生改变
	private ImmutableValue currentValue = null;

	public ImmutableValue getValue() {
		return currentValue;
	}
	
	public void setValue(ImmutableValue newValue) {
		this.currentValue = newValue;
	}

	public void add(int newValue) {
		this.currentValue = this.currentValue.add(newValue);
	}
	
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		ImmutableValue i1 = new ImmutableValue(2);
		ImmutableValue i2 = new ImmutableValue(3);
		// 调用 setValue 时将新的引用指过去了，所以 c1 的 ImmutableValue 就发生了改变
		c1.setValue(i1);
		int value = c1.getValue().getValue();
		System.out.println(value);
		c1.setValue(i2);
		int value2 = c1.getValue().getValue();
		System.out.println(value2);
		// 调用 app 方法时先通过 ImmutableValue 的 add 方法生成了一个新的对象，再把这个对象的引用指过去，所以 c1 的 ImmutableValue 也发生了改变
		c1.add(3);
		System.out.println(c1.getValue().getValue());
		
	}
}
