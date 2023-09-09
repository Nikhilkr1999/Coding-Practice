package com.leetcode.array.easy;

public class MaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {5,4,-1,7,8};
		System.out.println(maxSubArray(arr));
	}

	public static int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
        int maxSum = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	//System.out.println(sum);
        	
        	if(sum + nums[i] > nums[i]) {
        		sum = sum + nums[i];
        	} else {
        		//System.out.println(nums[i]);
        		sum = nums[i];
        	}
        	System.out.println(sum);
        	if(sum > maxSum) {
        		maxSum = sum;
        	}
        }
        
        
        return maxSum;
    }
}
