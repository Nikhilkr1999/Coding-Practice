package com.leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TwoSum {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		int[] res = new int[2];
		res = twoSum(arr, target);
		System.out.println(res[0] + " " + res[1]);
		
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		res[0] = res[1] = -1;
		Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		
		for(int i = 0; i < nums.length; i++) {
			res[0] = res[1] = -1;
			int curNum = nums[i];
			if(map.containsKey(curNum)) {
				map.get(curNum).add(i);
				/*
				 * set.add(i); map.put(curNum, set);
				 */
			} else {
				HashSet<Integer> newSet = new HashSet<Integer>();
				newSet.add(i);
				map.put(curNum, newSet);
			}
			int searchNum = target - nums[i];
			
			if(map.containsKey(searchNum)) {
				HashSet<Integer> curSet = map.get(searchNum);
				if( searchNum == nums[i]) {
					if(curSet.size() > 1) {
						// the array has duplicate no.
						res[0] = i;
						Iterator<Integer> iter = curSet.iterator();
						while(iter.hasNext()) {
							int temp = iter.next();
							if(temp != i) {
								res[1] = temp;
								break;
							}
						}
						return res;
					}
					continue;
				}
				res[0] = i;
				res[1] = curSet.iterator().next();
				return res;
			}
		}
		return res;
        
    }
}
