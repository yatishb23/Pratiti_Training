package com.yatish.reflection;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionDemo {
	public ReflectionDemo() {
		Person p =new Person();
		displayObjectInf(p);
	}
	public void displayObjectInf(Object o) {
		Class c=o.getClass();
		System.out.println(Person.class.getClass());
		System.out.println(c);
		System.out.println(c.getModifiers());
		System.out.println(c.getPackageName());
		System.out.println(Arrays.toString(c.getDeclaredMethods()));

		ConcurrentHashMap<String, Integer> map=new ConcurrentHashMap<>();
		
	}
}
