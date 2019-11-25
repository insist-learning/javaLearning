package com.dj.thinkingInJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestMap {
	/*静态代码块随着类的加载而执行，并且只一次*/
	static {
	    // 测试githut的更新，11
	}
        static {
	   // 静态代码可以有多个，测试
	}
	public static void main(String[] args) {
		// 用 map 来统计 key 出现的次数
		/**
		 * map.values():所有 values 的集合
		 */
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		Random rd = new Random();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			int r = rd.nextInt(20);
			Integer count = map.get(r);
			map.put(r, count==null?1:count+1);
		}
		System.out.println(map);
		System.out.println(map.values());
		fun1();
	}
	private static void fun1() {
		System.out.println(1);
		fun2(null);
	}
	private static void fun2(String str) {
		System.out.println(2);
		int i = 1;
		System.out.println(i);
	}
}
