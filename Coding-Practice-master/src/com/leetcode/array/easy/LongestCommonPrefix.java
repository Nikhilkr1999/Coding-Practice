package com.leetcode.array.easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[0];
		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
       String finalStr = "";
       Boolean isMatched = true;
       int index = 0;
       if(strs.length == 1) {
           finalStr = strs[0];
           return finalStr;
       } 
       
       if(strs != null && strs.length > 0) {
    	   while(isMatched) {
        	   for(int i = 0;i < strs.length - 1; i++) {
        		   if(strs[i].length() >= index && strs[i+1].length() >= index &&
        				   strs[i].charAt(index) == strs[i+1].charAt(index)) {
        			   continue;
        		   } else {
        			   
        			   isMatched = false;
        			   break;
        		   }
        	   }
        	   if(isMatched) {
        		   finalStr += strs[index].charAt(index);
        		   index++;
        	   }
           }
       }
       
       
       
       return finalStr;
    }

}
