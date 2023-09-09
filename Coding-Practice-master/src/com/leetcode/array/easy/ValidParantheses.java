package com.leetcode.array.easy;

import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		if(s == null || s.length() == 0) {
			return true;
		}
		
		for(int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			switch(ch) {
				case '(':
				case '{':
				case '[':
					stack.add(ch);
					break;
					
				case ')':
				case '}':
				case ']':
					if(stack.isEmpty()) {
						return false;
					}
					Character top = stack.pop();
					if((ch == ')' && top != '(' ) || (ch == '}' && top != '{' ) || (ch == ']' && top != '[' )) {
						return false;
					}
				
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		} else {
			return false;
		}    
    }
}
