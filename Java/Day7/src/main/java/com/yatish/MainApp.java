package com.yatish;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;


import com.yatish.set.SetDemo;

public class MainApp {
	public static void main(String[] args) throws FileNotFoundException, IOException, NotSerializableException {
		SetDemo s1=new SetDemo();
		s1.example();
		s1.save();
	}
}
