package com.dj.thread.imutablility;

public class Test {
	public static void main(String[] args) {
//		ImmutableValue i1 = new ImmutableValue(3);
//		ImmutableValue i2 = i1.add(2);
//		System.out.println(i1.getValue());
//		System.out.println(i2.getValue());
		
		
		
		Calculator c1 = new Calculator();
		ImmutableValue i1 = new ImmutableValue(2);
		ImmutableValue i2 = new ImmutableValue(3);
		c1.setValue(i1);
		int value = c1.getValue().getValue();
		System.out.println(value);
		c1.setValue(i2);
		int value2 = c1.getValue().getValue();
		System.out.println(value2);
		
		c1.add(3);
		int value3 = c1.getValue().getValue();
		System.out.println(value3);
		
	}
}
