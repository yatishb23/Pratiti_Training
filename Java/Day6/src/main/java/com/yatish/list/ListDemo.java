package com.yatish.list;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ListDemo {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(3);
		list.add(34);
		
//		list.forEach(a -> System.out.println(a));
//		System.out.println(list);
//		list.remove(list.get(0));
//		list.set(0, 10);
//		System.out.println(list);
//		
//		list.removeAll(new ArrayList<>());
//		list.removeIf(a -> a%2==0);
//		
//		System.out.println(list);
//		Iterator it=list.iterator();
//		System.out.println(it.next());
		
		
		List<Integer> a=new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		Stream<Integer> stream=a.stream();
		Consumer consumer=new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
			
		};

		Consumer c1=(t)-> System.out.println(t);
		Predicate<Integer> ps=(t)-> t.equals(1);
		a.stream().filter(ps).forEach(c1);;
		System.out.println(a.stream().filter(ps).toList());
		a.stream();
//		stream.forEach(consumer);
	}
}
