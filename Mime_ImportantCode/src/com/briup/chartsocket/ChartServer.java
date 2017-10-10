package com.briup.chartsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class HandlerSocket extends Thread{
	private Socket socket;
	public HandlerSocket(Socket socket) {
		this.socket=socket;
	}
	public void run() {
		try{
			new Thread(){
				@Override
				public void run() {
					PrintWriter pw=null;
					Scanner sc=null;
					try {
						pw=new PrintWriter(socket.getOutputStream());
						pw.println("客户"+getName()+"：为你服务!");
						pw.flush();
						sc=new Scanner(System.in);
						while(sc.hasNextLine()){
							String msg=sc.nextLine();
							pw.println(msg);
							pw.flush();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						try {
							if(pw!=null)pw.close();
							if(sc!=null)sc.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
			}.start();
			BufferedReader br=null;
			String line;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while ((line = br.readLine())!=null){
				System.out.println("client say："+line);
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(socket!=null)socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}

public class ChartServer {
	static boolean flag=true;
	public static void main(String[] args) {
		ServerSocket server=null;
		try {
			server=new ServerSocket(8888);
			while(flag){
				final Socket socket=server.accept();
				//分配一个线程处理客户端的请求
				new HandlerSocket(socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(server!=null){
					server.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
