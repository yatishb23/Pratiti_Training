package com.yatish.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.nau.pet.*;

public class DeserializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis=new FileInputStream("blanket");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Object o=ois.readObject();
		System.out.println(o);
		ois.close();
	}
}	
