package com.leetcode.medium;

public class ContainMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {1,1};
		System.out.println(maxArea(arr));

	}

	public static int maxArea(int[] height) {
	
	   if(height == null || height.length == 0) {
		   return 0;
	   }
       int max = Integer.MIN_VALUE;
       int len = height.length;
       for(int i = 0, j = len - 1; i<j; ) {
    	   int currentArea = Math.min(height[i], height[j]) * (j-i);
    	   if(currentArea > max) {
    		   max = currentArea;
    	   }
    	   if(height[i] < height[j]) {
    		   i++;
    	   } else {
    		   j--;
    	   }
       }
       return max;
    }
}
