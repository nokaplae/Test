package com.java.ex.test;

public class Test {
	
	public static void main(String[] args)  {
		
		
		String sentence = ".?2-=+-=//";
		
		char[] words = sentence.toCharArray();
		
		for(int i=0; i<words.length; i++) {
			
			
			if((words[i] >= 33 && words[i] <= 47) || (words[i] >= 58 && words[i] <= 64)
					|| (words[i] >= 91 && words[i] <= 96) || (words[i] >= 123 && words[i] <= 126)) {
				
				System.out.println("특수문자");
			} else if(words[i] >= 48 && words[i] <= 57) {
				System.out.println("숫자");
			} else if(words[i] >= 65 && words[i] <= 122) {
				System.out.println("영어");
			} else {
				System.out.println("그밖에");
			}
			
			
		}
		
	}
}

/*	char_ASCII>=33 && char_ASCII<=47
char_ASCII>=58 && char_ASCII<=64
char_ASCII>=91 && char_ASCII<=96
char_ASCII>=123 && char_ASCII<=126


출처: https://fallacy.kr/112 [fallacy.kr]

	}
	*/
	

