package com.leetcode.medium;

import java.util.Arrays;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr =  new int[] {1,2,0,1};
		
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println(res(arr));
	}
	
	/*
	 * public static boolean canJump(int[] nums, int index) { int length =
	 * nums.length; for( int j = index, i = 1; index + i < length && j <=
	 * nums[index]; j++, i++) { System.out.println("i = " + i + ", nums[j] = " +
	 * nums[j] + ", j = " + j + ", length = " + length); if( nums[j] + i == length)
	 * { res = true; return true; } canJump(nums, index + i); } return false; }
	 */
	
	static boolean gotPath = false;
	
	public static boolean res(int[] nums) {
		int len = nums.length;
		boolean res = false;
		for(int i = len-2, j = len-1; i >= 0;) {
			if(nums[i] + i >= j) {
				j = i;
				i--;
				res = true;
			} else {
				i--;
				res = false;
			}
		}
		
		return res;
	}
}
