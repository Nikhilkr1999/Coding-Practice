package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class MinDeletionOfChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aaabbbcccdddeeefffggghhhiiijjjkkklllmmmnnnooop";
		System.out.println(findMinimumDeletions(s));
	}
	
	public static int minDeletions(String s) {
		int count = 0;
		int[] arr = new int[26];
		Set<Integer> set = new HashSet<Integer>();
		arr[0] = 0;
		for(int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 97]++;
		}
		
		for(int i = 0; i < 26; i++) {
			if(arr[i] == 0 ) {
				continue;
			}
			int curFreq = arr[i];
			boolean doesContain = set.contains(curFreq);
			if(doesContain) {
				while(doesContain && curFreq > 0) {
					curFreq--;
					count++;
					if(set.contains(curFreq)) {
						continue;
					} else {
						set.add(curFreq);
						break;
					}
				}
			} else {
				set.add(curFreq);
			}
		}
		return count;
		
    }
	
	
	public static int findMinimumDeletions(String input) {
		int ct =0;
		input = input.toLowerCase();
		TreeMap<Integer,ArrayList<Character>> countCharsMap = new TreeMap<Integer,ArrayList<Character>>();
		int[] count = new int[26];
		char[] arr = input.toCharArray();
		for(int i=0;i<arr.length;i++) {
			int index =(int)arr[i]-97 ;
			count[index]++;
		}
		
		for(int i =0;i<count.length;i++) {
			ArrayList<Character> values = new ArrayList<Character>();
			if(count[i] != 0) {
				if(countCharsMap.containsKey(count[i])) {
					values = countCharsMap.get(count[i]);
					values.add((char)(i+97));
					
				}else {
					values.add((char)(i+97));
				}
				countCharsMap.put(count[i], values);
			}
			
		}
		
		Set<Integer> keys = countCharsMap.keySet();
		
		Set<Integer> resultSet = new HashSet<Integer>();
		Iterator<Integer> keySet = keys.iterator();
		while(keySet.hasNext()) {
			Integer key = keySet.next();
			resultSet.add(key);
			ArrayList<Character> values = countCharsMap.get(key);
		}
		
		
		Iterator<Integer> keySet1 = keys.iterator();
		while(keySet1.hasNext()) {
			Integer key = keySet1.next();
			Integer tempKey = key;
			ArrayList<Character> values = countCharsMap.get(key);
			if(values.size()== 1) {
			}else {
				for(int i=0;i<values.size()-1;i++) {
					tempKey = key;
					while(resultSet.contains(tempKey--)) {
						ct++;
					}
					if(++tempKey != 0) {
						resultSet.add(tempKey);
					}
					
				}
			}
		}
		
		return ct;
		
	}

}
