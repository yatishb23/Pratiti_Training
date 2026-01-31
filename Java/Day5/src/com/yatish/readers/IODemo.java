package com.yatish.readers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class IODemo {
public static void main(String[] args) throws IOException {
	InputStream iStream=System.in;
	InputStreamReader isr=new InputStreamReader(iStream);
	BufferedReader br=new BufferedReader(isr);
	String aString=br.readLine();
	
	OutputStream oStream=System.out;
	OutputStreamWriter wsr=new OutputStreamWriter(oStream);
	BufferedWriter bw=new BufferedWriter(wsr);
	bw.write(aString);
	bw.flush();
}
}
class MareOutputStream extends OutputStream{
	@Override
	public void write(int b) throws IOException{
		
	}
}
