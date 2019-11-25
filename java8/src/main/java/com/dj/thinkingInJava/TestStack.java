package com.dj.thinkingInJava;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TestStack {
	public static void main(String[] args) {
		/**
		 * stack 先进后出
		 * push():添加至头部，进栈（从头部进入）
		 * peek():取头部
		 * pop():从头部移除，出七（从头部出去）
		 */
//		Stack<String> stack = new Stack<String>();
//		for (String s: "My dogs has files".split(" "))
//			stack.push(s);
//		while (!stack.empty()) 
//			System.out.println(stack.pop());
		
		
		/**
		 * Set 最常用的方法：contains,containsAll
		 * Random(47)：47 是产生随机数的一个种子，随机数产生时需要一个种子，如果没有说明则默认取系统的当前时间
		 * SortedSet ：TreeSet 的一种实现，可以对结果进行排序
		 */
//		SortedSet<Integer> intset = new TreeSet<Integer>();
//		Random rand = new Random(47);
//		Set<Integer> intset = new HashSet<Integer>();
		
//		for (int i = 0; i < 100000; i++) {
//			intset.add(rand.nextInt(30));
//		}
//		System.out.println(intset);
		
		Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		Collections.addAll(words, "C B A a".split(" "));
		System.out.println(words);
		
	}
}
