package com.yatish.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) {
		Properties prop=new Properties();
		
		prop.setProperty("username", "yatish");
        prop.setProperty("password", "12345");
        prop.setProperty("url", "http://example.com");

        File file = new File("config.properties");

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + file.getAbsolutePath());
            }

            try (FileOutputStream fos = new FileOutputStream(file)) {
                prop.store(fos, "Automatically generated properties file");
                System.out.println("Properties saved successfully!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(prop.getProperty("username"));
	}
}
