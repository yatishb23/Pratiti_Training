package com.yatish.set;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;


import com.yatish.models.Employee;

public class SetDemo implements Serializable{
	
	static Map<Integer, Employee> map;
	
	static {
		boolean r=new File("employee.txt").exists();
		if(r) {
			try {
				FileInputStream fis=new FileInputStream(new File("employee.ser"));
				ObjectInputStream ois=new ObjectInputStream(fis);
				map=(Map<Integer, Employee>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			map=new HashMap<>();
		}
	}
	public void example() {
		Employee e1=new Employee(1,"Yatish");
		Employee e2=new Employee(4,"Badgujar");
		Employee e3=new Employee(2,"Pawan");
		Employee e4=new Employee(3,"Nikhil");
		
		
		map.put(1, e1);
		map.put(2, e2);
		map.put(3, e3);
		map.put(4, e4);
		
//		map.entrySet()
//		   .stream()
//		   .sorted((em1, em2) -> Integer.compare(em2.getValue().id(), em1.getValue().id()))
//		   .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
//
//		
//		System.out.println(
//		map.entrySet()
//        .stream()
//        .filter(e -> e.getValue().name() == "Yatish")
//        .count());
		
		Set<Employee> set=new HashSet<>();
		System.out.println(set.add(e1));
		System.out.println(set.add(e2));
		System.out.println(set.add(e3));
		System.out.println(set.add(e4));
		
		System.out.println();
		
		set.forEach((e)->{System.out.println(e.id()+" "+e.name());});
		
		System.out.println();
		
		set.stream()
		   .sorted((em1, em2) -> Integer.compare(em1.id(), em2.id()))
		   .forEach(e -> System.out.println(e.id() + " " + e.name()));

	}

	public void save() {
	    try (ObjectOutputStream oos =
	             new ObjectOutputStream(new FileOutputStream("employee.ser"))) {

	        oos.writeObject(map);
	        System.out.println("Saved");

	    } catch (NotSerializableException e) {
	        System.out.println("Employee or Map is not Serializable");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}

record Student() {
	
}
