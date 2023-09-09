package com.leetcode.array.easy;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord(" a"));
	}
	
	 

	 public static int lengthOfLastWord(String str) {
		 if(str == null || str.length() == 0) {
			 return 0;
		 }
		 String[] splited = str.split("\\s+");
		 String string = splited[0];
		 if(string != " ") {
			 return string.length();
		 }
		 return 0;
	 }
}

