package com.briup.morethreaddownloadfile;

import java.io.IOException;
import java.io.RandomAccessFile;

class ThreadDownloadFile extends Thread{
	private RandomAccessFile in=null;
	private RandomAccessFile out=null;
	private long start=0;
	private long end=0;
	public ThreadDownloadFile(RandomAccessFile in,RandomAccessFile out,long start,long end) {
		this.in=in;
		this.out=out;
		this.start=start;
		this.end=end;
	}
	@Override
	public void run() {
		String name=getName();
		System.out.println(name+"..........");
		try {
			byte[] b=new byte[1024];
				while(start<end){
					synchronized (ThreadDownloadFile.class) {
					in.seek(start);
					out.seek(start);
					int len=in.read(b);
					if((len+start)>end){
						len=(int) (end-start);
						out.write(b, 0, len);
						System.out.println(name+": "+len);
						break;
					}
					out.write(b, 0, len);
					start=start+len;
					System.out.println(name+": "+len);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class XunLei {
	public static void main(String[] args) throws Exception{
		RandomAccessFile in=new RandomAccessFile("src/com/briup/morethreaddownloadfile/image.jpg", "r");
		RandomAccessFile out=new RandomAccessFile("src/com/briup/morethreaddownloadfile/copypimage.jpg", "rw");
		int count=3;
		long length=in.length();
		System.out.println(length);
		long x=length/count;
		for(int i=0;i<count;i++){
			long start=x*i;
			long end=x*(i+1);
			if(i==(count-1)){
				new ThreadDownloadFile(in, out, start, length).start();
			}else{
				new ThreadDownloadFile(in, out, start, end).start();
			}
		}
	}
}
