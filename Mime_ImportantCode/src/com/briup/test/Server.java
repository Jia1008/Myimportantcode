package com.briup.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket server=null;
		try {
			server=new ServerSocket(9999);
			System.out.println("等待客户端连接。。。。。");
			Socket socket=server.accept();
			InputStream in=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(isr);
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("客户端说："+info);
			}
			socket.shutdownInput();
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("欢迎你！");
			pw.flush();
			pw.close();
			os.close();
			br.close();
			isr.close();
			in.close();
			socket.close();
			server.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		
	}
}
