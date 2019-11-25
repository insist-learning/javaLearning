package com.dj.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.dj.bean.User;

public class Test {
	private void fun() {
		try {
			
		} catch (Exception e) {
			throw new NullPointerException("df");
		}
	}
	
	public static void main(String[] args)  {
		User defaultUser = new User("admin",999);
		
		Optional<User> op = Optional.of(new User("张三",23));
		Optional<User> op2 = Optional.ofNullable(null);
		
		// ifPresent:如何存在值则返回 true
//		System.out.println(op.isPresent());
//		System.out.println(op2.isPresent());
		
		// get:取值
//		System.out.println(op.get().getAge());
//		System.out.println(op2.get().getAge());
		
		// ifPresent 如何存在则做什么操作,Consumer
//		op.ifPresent((a)->System.out.println(a.getName()));
//		op2.ifPresent((a)->System.out.println(a.getName()));
		
		// orElse:如何不存在则使用指定的值
//		System.out.println(op.orElse(defaultUser).getName());
//		System.out.println(op2.orElse(defaultUser).getName());
		
		
		// orElse:如何不存在则使用指定的值,Summplier
//		String name = op.orElseGet(()->{
//			return new User("ADMIN",99);
//		}).getName();
//		
//		String name2 = op2.orElseGet(()->{
//			return new User("ADMIN",99);
//		}).getName();
//		System.out.println(name);
//		System.out.println(name2);
		
		// orElseThrow 如何不存在则抛出异常
//		op2.orElseThrow(NoUserException::new).getAge();
		
		// map :转换对象,lamda 参数为当前的对象
		// Optional<User>-->Optional<String>
//		System.out.println(op2.map(User::getName).orElse("noName"));
		
		List<String> list = Arrays.asList("a","b","c");
//		Optional.of(list).ifPresent(l);
		
	}
}
