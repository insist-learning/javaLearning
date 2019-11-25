package com.dj.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dj.bean.Employee;

public class Test {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(
				new Employee("张三", 10, 10.0),
				new Employee("李四", 20, 5.5),
				new Employee("王五", 30, 80.0),
				new Employee("小明2", 44, 20.0),
				new Employee("小明3", 44, 80.0),
				new Employee("小明", 44, 100.0),
				new Employee("小草", 44, 22.5));
		
		// 转换对象 map,stream 用在集合中默认 lamda 的参数为每个对象,类型为集合参数的类型 
		// Stream<Employee>-->Stream<Double>
		List<Double> doubleList = list.stream().map(Employee::getMoney).collect(Collectors.toList());
		System.out.println(doubleList);
		
		
		// 取list中的某个属性，并且符号分隔
		String names = list.stream().map(Employee::getName).collect(Collectors.joining(","));
		System.out.println(names);
		
		// 从集合中取满足需要的对象
		List<Employee> manyMoney = list.stream().filter(a->a.getMoney()> 20).collect(Collectors.toList());
		System.out.println(manyMoney);
		
		// 排序,以下是按年龄排序，如果年龄一样，则按照工资，年龄是从小排到大，工资是从大排到小
		List<Employee> orderList = list.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing((a,b)->{
			if (a.getMoney() > b.getMoney()) {
				return -1;
			} else if (a.getMoney() < b.getMoney()) {
				return 1;
			} else {
				return 0;
			}
		})).collect(Collectors.toList());
		orderList.forEach(a->System.out.println(a));
		// 去除重复的，如果年龄有重复的，只取工资最高的那个
		ArrayList<Employee> noRepeat = list.stream().sorted((a,b)->Double.compare(b.getMoney(), a.getMoney())).collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(
				Comparator.comparing(Employee::getAge) 
				)), ArrayList::new));
		noRepeat.forEach(a->System.err.println(a));
	}
	
	

}
