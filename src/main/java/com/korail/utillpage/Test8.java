package com.korail.utillpage;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

//http://dd00oo.tistory.com/entry/JAVA-%EC%95%94%ED%98%B8%ED%99%94
public class Test8 {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {
		AES256Util util = new AES256Util("abcdefghijklmnop");
		String str = util.encrypt("1234");
		System.out.println("STR="+str);
		//String str2 = util.decrypt(str);
		//System.out.println("STR2="+str2);
	}
}
