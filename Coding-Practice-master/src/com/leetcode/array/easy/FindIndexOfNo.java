package com.leetcode.array.easy;

public class FindIndexOfNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,4,8,9,12,17,19};
		System.out.println(searchInsert(arr,4));
	}
	
	public static int searchInsert(int[] nums, int target) {
        int index = -1;
        
        int start = 0;
        int end = nums.length - 1;
        
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        
        if(target < nums[0]) {
        	return 0;
        }
        
        if(target > nums[nums.length - 1]) {
        	return nums.length;
        }
        
        while(start <= end) {
        	int mid = (start + end) / 2;
        	System.out.println(mid + " " + nums[mid] + " " + target);
        	if(nums[mid] == target) {
        		System.out.println("found target");
        		return mid;
        	} else if(nums[mid] > target) {
        		end = mid -1;
        	} else {
        		start = mid + 1;
        	}
        }
        
        		
        
        return start;
        
        
    }

}
