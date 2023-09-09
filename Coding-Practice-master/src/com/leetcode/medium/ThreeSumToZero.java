package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ThreeSumToZero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		 int[] arr = new int[n]; 
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt(); 
		 }
		 System.out.println(threeSum(arr));
		 
		 
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();	
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		int n = nums.length;
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				int sum = nums[i] + nums[j];
				if(map.containsKey(sum)) {
					List<Integer> existingList = map.get(sum);
					existingList.add(i);
					existingList.add(j);
					map.put(sum, existingList);
				} else {
					List<Integer> existingList = new ArrayList<Integer>();
					existingList.add(i);
					existingList.add(j);
					map.put(sum, existingList);
				}
			}
		}
		System.out.println(map);
		for(int i = 0; i < n; i++) {
			int currentNum = nums[i];
			int required = 0 - currentNum;
			System.out.println("Current Num :::  " + currentNum + "  ::: Required Num :::  " + required);
			if(map.containsKey(required)) {
				List<Integer> list = map.get(required);
				System.out.println("List ::: " + list);
				for( int j = 0; j < list.size() - 1; j += 2) {
					System.out.println("J ::: " + j);
					if(list.get(j) != i && list.get(j+1) != i) {
						List<Integer> res = new ArrayList<Integer>();
						res.add(nums[i]);
						res.add(nums[list.get(j)]);
						res.add(nums[list.get(j+1)]);
						map.put(required, list);
						result.add(res);
						System.out.println(i + " ::: " + list.get(j)  + " ::: " + list.get(j+1));
						System.out.println(res);
					}
				}
			}
		}
		
		return result;
        
    }

}
