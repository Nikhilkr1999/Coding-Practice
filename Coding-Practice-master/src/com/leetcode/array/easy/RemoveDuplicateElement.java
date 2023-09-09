package com.leetcode.array.easy;

import java.util.Arrays;

public class RemoveDuplicateElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr  = new int[] {0,1,2,2,3,0,4,2};
		
		System.out.println(removeElement(arr, 2));
		System.out.println(Arrays.toString(arr));
	}
	
	public static int removeElement(int[] nums, int val) {
        int index = 0;
        int length = nums.length;
        
        if(length == 0) {
            return 0;
        }
        
        int currentVal = nums[0];
        for(int i = 0; i < length; i++) {
        	currentVal = nums[i];
            if(currentVal == val) {
                continue;
            } else {
                nums[index] = nums[i];
                currentVal = nums[i];
                index++;
            }
        }
        return index;
        
    }

}
