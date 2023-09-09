package com.leetcode.array.easy;

import java.util.Arrays;

public class MergeSortedArrayInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1 = new int[] {1};
		int[] nums2 = new int[] {};
		merge(nums1, 1, nums2, 0);
		System.out.println(Arrays.toString(nums1));
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
    
		int last = nums1.length - 1;
		int first = m - 1;
		int second = n - 1;
		
		/*
		 * while(nums1[first] == 0) { first--; }
		 */
		
		while(first >= 0 && second >= 0) {
			
			int firstNum = nums1[first];
			int secondNum = nums2[second];
			
			if(firstNum > secondNum) {
				nums1[last--] = firstNum;
				first--;
			} else {
				nums1[last--] = secondNum;
				second--;
			}
		}
		
		while(first >= 0) {
			nums1[last--] = nums1[first--];
		}
		
		while(second >= 0) {
			nums1[last--] = nums2[second--];
		}
    }

}
