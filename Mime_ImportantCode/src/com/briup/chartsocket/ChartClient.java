package com.briup.chartsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class MessageThread extends Thread{
	private Socket socket;
	public MessageThread(String name,Socket socket) {
		super(name);
		this.socket=socket;
	}
	public void run() {
		PrintWriter pw=null;
		Scanner sc=null;
		Scanner sc1=null;
		try {
			pw=new PrintWriter(socket.getOutputStream(),true);
			sc=new Scanner(socket.getInputStream());
			if(Thread.currentThread().getName().equals("read")){
				while(sc.hasNextLine()){
					System.out.println("server say:"+sc.nextLine());
				}
			}else if(Thread.currentThread().getName().equals("write")){
				sc1=new Scanner(System.in);
				while(sc1.hasNextLine()){
					String msg=sc1.nextLine();
					pw.println(msg);
					pw.flush();
						//break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(socket!=null){
					socket.close();
				}
				if(pw!=null){
					pw.close();
				}
				if(sc!=null){
					sc.close();
				}
				if(sc1!=null){
					sc1.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}

public class ChartClient {
	public static void main(String[] args) {
		Socket socket=null;
		boolean flag=true;
		try {
			socket=new Socket("127.0.0.1", 8888);
//			sc=new Scanner(socket.getInputStream());
//			pw=new PrintWriter(socket.getOutputStream(),true);
			System.out.println("准备读取服务端信息。。。。");
		//	while(sc.hasNextLine()){
			//	System.out.println("server say:"+sc.nextLine());
			new MessageThread("read",socket).start();
			new MessageThread("write", socket).start();	
//				sc1=new Scanner(System.in);
//				while(sc1.hasNextLine()){
//					String msg=sc1.nextLine();
//					pw.println(msg);
//					pw.flush();
//					break;
//				}
				//continue;
			//}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
