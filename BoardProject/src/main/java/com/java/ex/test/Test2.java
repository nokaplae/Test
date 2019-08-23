package com.java.ex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) {
		
		String str = "111 ";
		
		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}$");
		Pattern n = Pattern.compile("[0-9]{4}");
		// 
		Matcher m = n.matcher(str);
		
		System.out.println(m.find());
	}
}
