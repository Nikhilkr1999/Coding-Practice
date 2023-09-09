package com.leetcode.array.easy;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int firstBadVersion(int n) {
		 int start = 0;
	     int end = n - 1;
	     int firstBadVersion = Integer.MAX_VALUE;
	     while(start <= end) {
        	int mid = (start + end) / 2;
        	if(isBadVersion(mid)) {
        		if(firstBadVersion > mid) {
        			firstBadVersion = mid;
        		}
        		end = mid - 1;
        	} else {
        		start = mid + 1;
        	}
        }
	     
	    return start > firstBadVersion ? firstBadVersion : start;
        
    }
	
	boolean isBadVersion(int version) {
		return false;
	}

}
