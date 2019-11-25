package com.dj.bean;

public class Employee {
	private String name;
	private int age;
	private Double money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", money=" + money + "]";
	}
	public Employee(String name, int age, Double money) {
		super();
		this.name = name;
		this.age = age;
		this.money = money;
	}
	
}
