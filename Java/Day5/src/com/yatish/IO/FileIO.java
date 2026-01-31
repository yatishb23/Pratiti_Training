package com.yatish.IO;

import java.io.*;



public class FileIO {
	static InputStream is=System.in;
	static InputStreamReader isr=new InputStreamReader(is);
	static BufferedReader br=new BufferedReader(isr);
	
	public static void main(String[] args) throws IOException {
		String msg="Name,City\n";
		File file=new File("output.txt");
		
		
		if(!file.exists()) {
			System.out.println(file.getAbsolutePath());
			try(FileOutputStream fs=new FileOutputStream("output.txt")){
				fs.write(msg.getBytes());
				System.out.println("File created");
				addEmployee(file);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			
			addEmployee(file);

		}
		dummyDeb(file);
		FileInputStream is1=new FileInputStream(file);
		int data;
		while((data=is1.read())!=-1) {
			System.out.print((char)data);
		}
		
		
		is.close();
	}
	public static void dummyDeb(File file) throws IOException {
		FileOutputStream fs=new FileOutputStream(file,true);
		fs.write("Yatish is god".getBytes());
		fs.flush();
	}
	public static void addEmployee(File file) throws IOException {
		FileWriter fw=new FileWriter(file,true);
		while(true) {
			System.out.print("Do you want to add employee : [Y/n] ");
			String name;
			String city;
			
			String cString=br.readLine();
			
			if(cString.compareToIgnoreCase("Y")==0) {
				System.out.println("Enter name: ");
				name=br.readLine();
				System.out.println("Enter city: ");
				city=br.readLine();
				fw.write(name+","+city+"\n");
			}
			else {
				break;
			}
			
		}
		fw.close();
	}
}


//		BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt", true));
//		bw.write(" "+msg);
//		bw.newLine();
//		bw.close();		
		
//		String msg="Help";
//		try(FileOutputStream fo=new FileOutputStream("output.txt")){
//			fo.write(msg.getBytes());
//			System.out.println("file updated");
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
////		FileOutputStream fo=new FileOutputStream("Output.txt");
//		
//		InputStream is = new FileInputStream("output.txt");
//        int data;
//        while ((data = is.read()) != -1) {
//            System.out.print((char) data); 
//        }
//        is.close();
