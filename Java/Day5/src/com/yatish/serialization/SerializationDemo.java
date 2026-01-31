package com.yatish.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) throws IOException {
		Dog dog=new Dog();
		System.out.println(dog);
		
		FileOutputStream fos=new FileOutputStream("blanket");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(dog);
		
		System.out.println("Dog wrapped in blanket");
	}
}
