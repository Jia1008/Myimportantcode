package com.briup.sha1;

import java.security.DigestException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date.getTime());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("timestamp", date.getTime());
		map.put("Token", "WeChart");
		map.put("nonce", "1314");
		try {
			String x=Sha1.SHA1(map);
			System.out.println(x);
		} catch (DigestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
