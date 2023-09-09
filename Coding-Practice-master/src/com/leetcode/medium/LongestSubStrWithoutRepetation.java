package com.leetcode.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class LongestSubStrWithoutRepetation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(lengthOfLongestSubstring1("aab!"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
      Integer count = 0;
      Integer max = Integer.MIN_VALUE;
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      TreeMap<Integer, Character> treeMap = new TreeMap<Integer, Character>();
      for(int i = 0; i < s.length(); i++) {
    	  Character ch = s.charAt(i);
    	  if(!map.containsKey(ch)) {
    		  map.put(ch, i);
    		  treeMap.put(i, ch);
    		  System.out.println("ch ::: " + ch);
    		  count++;
    	  } else {
    		  if(count > max) {
    			  max = count;
    		  }
    		  
    		  Integer oldIndex = map.get(ch);
    		  System.out.println("oldIndex ::: " + oldIndex);
    		  Iterator<Integer> iter = treeMap.keySet().iterator();
    		  while(iter.hasNext()) {
    			  Integer index = iter.next();
    			  if(index < oldIndex) {
    				  map.remove(treeMap.get(index));
    			  } else {
    				  break;
    			  }
    		  }
    		  map.put(ch, i);
    		  treeMap.put(i, ch);
    		  count = i - map.get(ch);
    		  
    		  System.out.println("Count ::: " + count + " ::: ch ::: "  + ch );
    	  }
      }
      return count > max ? count : max;
    }
	
	public static int lengthOfLongestSubstring1(String s) {
	      Integer count = 0;
	      Integer max = Integer.MIN_VALUE;
	      String temp = "";
	      Map<Character, Integer> map = new HashMap<Character, Integer>();
	      for(int i = 0; i < s.length(); i++) {
	    	  Character ch = s.charAt(i);
	    	  if(!map.containsKey(ch)) {
	    		  map.put(ch, i);
	    		  temp += ch;
	    		 // System.out.println("ch ::: " + ch);
	    		  count++;
	    	  } else {
				/*
				 * if(count > max) { max = count; }
				 */
	    		  if(temp.length() > max) {
	    			  max = temp.length();
	    		  }
	    		  int tempBeginIndex = 0;
	    		  for(int j = 0; j < temp.length(); j++) {
	    			  Character tempCh = temp.charAt(j);
	    			  if(tempCh == ch) {
	    				  tempBeginIndex = j;
	    				  map.remove(tempCh);
	    				  break;
	    			  } else {
	    				  map.remove(tempCh);
	    			  }
	    		  }
	    		  if(tempBeginIndex + 1 <= temp.length()) {
	    			  temp = temp.substring(tempBeginIndex + 1, temp.length());
	    		  } else {
	    			  temp = "";
	    		  }
	    		  if(temp.length() > max) {
	    			  max = temp.length();
	    		  }
	    		  temp += ch;
	    		  map.put(ch, i);
	    		  count = i - map.get(ch);
	    		  
	    		 // System.out.println("Count ::: " + count + " ::: ch ::: "  + ch );
	    	  }
	      }
	      return temp.length() > max ? temp.length() : max;
	    }

}
