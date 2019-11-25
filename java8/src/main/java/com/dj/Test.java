package com.dj;

import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
//		System.out.println(c);
		c.set(Calendar.SECOND, 51);
		System.out.println(c.getTime());
		

	}
}
