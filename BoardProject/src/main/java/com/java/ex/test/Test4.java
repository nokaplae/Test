package com.java.ex.test;

import java.util.Calendar;

public class Test4 {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;
		int date = cal.get(cal.DATE);
		
		
		System.out.println(month);
		
		
	}
}
