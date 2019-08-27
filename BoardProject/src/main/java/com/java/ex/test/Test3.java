package com.java.ex.test;

public class Test3 {
	public static void main(String[] args) {
		
		
		
		String target = "ノガプレ";
		   
		String regEx = "^[\u2e80-\u2eff\u31c0-\u31ef\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fbf\uf900-\ufaff]*$";
		String regEx2 ="^[\u30A0-\u30FF]*$";
		
		if (target.matches(regEx2)) {
		    System.out.println("일치");
		} else {
		    System.out.println("불일치");
		}

	}
}
