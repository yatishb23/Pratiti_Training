package com.yatish.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkIO {
 public static void main(String[] args) throws IOException {
//	ServerSocket serverSocket=new ServerSocket(5555);
//	for(;;) {
//		System.out.println("Waiting for client");
//		Socket userSocket=serverSocket.accept();
//		System.out.println(userSocket);
//		InputStream iStream= userSocket.getInputStream();
//		InputStreamReader isr=new InputStreamReader(iStream);
//		BufferedReader br=new BufferedReader(isr);
//		String string=br.readLine();
//		System.out.println(string);
//	}
	 Socket socket=new Socket("192.168.1.85",5555);
		OutputStream oStream=socket.getOutputStream();
		OutputStreamWriter wsr=new OutputStreamWriter(oStream);
		BufferedWriter bw=new BufferedWriter(wsr);
		bw.write("Kyaa pata ye message sir ke pc pe aaya ya nahi");
		bw.flush();
		socket.close();
	
}
 
 	public void client() throws IOException{
 		Socket socket=new Socket("192.168.1.85",5555);
 		OutputStream oStream=socket.getOutputStream();
 		OutputStreamWriter wsr=new OutputStreamWriter(oStream);
 		BufferedWriter bw=new BufferedWriter(wsr);
 		bw.write("Kyaa pata ye message sir ke pc pe aaya ya nahi");
 		bw.flush();
 		socket.close();
 	}

}
// 192 168 1 85 5555