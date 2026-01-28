package com.yatish.IO;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DialogBox {
	public static void main(String[] args) throws IOException {
		FileDialog f=new FileDialog(new Frame());
		f.setVisible(true);
		File file=new File(f.getFile());
		InputStream iStream=new FileInputStream(file);
		int data;
		while((data=iStream.read())!=-1) {
			System.out.print((char)data);
		}
		System.out.println("\n"+file.exists());
	}
}
