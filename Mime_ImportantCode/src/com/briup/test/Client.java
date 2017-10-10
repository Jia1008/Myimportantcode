package com.briup.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket=null;
		try {
			socket=new Socket("127.0.0.1", 9999);
			OutputStream os=socket.getOutputStream();
			System.out.println("���ӵ�������������");
			PrintWriter pw=new PrintWriter(os);
			pw.write("�û�����admin,���룺123");
			pw.flush();
			socket.shutdownOutput();
			InputStream in=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(isr);
			String line=null;
			while((line=br.readLine())!=null){
				System.out.println("��������˵��"+line);
			}
			br.close();
			isr.close();
			in.close();
			pw.close();
			os.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
