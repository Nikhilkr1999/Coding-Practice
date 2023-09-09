package com.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeOverlappingInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[][] interval = new int[][] { 
				/* {1,4}, {4,5} */
				
				  {1,3}//, {8,10}, {2,6}, {10,18}, {19,20}
				 
									   };
									   
		interval = mergeInterval(interval);
		System.out.println(Arrays.deepToString(interval));
		
	}
	
	
	public static int[][] mergeInterval(int[][] intervals) {
		/*
		 * //int[][] res = new int[3][]; List<List<Integer>> res = new
		 * ArrayList<List<Integer>>(); arr = sortArr(arr); int resCount = 0; //int[]
		 * temp = new int[2]; List<Integer> temp = new ArrayList<Integer>(); // temp[0]
		 * = arr[0][0]; temp.add(arr[0][0]); int[] curInterval = arr[0]; boolean isAdded
		 * = false; for(int i = 1; i < arr.length; i++) { if(temp == null) { //temp =
		 * new int[2]; //temp[0] = curInterval[0]; temp = new ArrayList<Integer>();
		 * temp.add(0,curInterval[0]); } int[] nextInterval = arr[i]; if(nextInterval[0]
		 * > curInterval[0] && nextInterval[0] <= curInterval[1]) { temp.add(1,
		 * nextInterval[1]); isAdded = false;
		 * 
		 * } else { temp.add(1,curInterval[1]); res.add(temp); isAdded = true; temp =
		 * null; } curInterval = arr[i];
		 * 
		 * } if(arr.length == 1) { temp.add(arr[0][1]); } if(isAdded) { temp = new
		 * ArrayList<Integer>(); temp.add(curInterval[0]); temp.add(curInterval[1]); }
		 * res.add(temp); int[][] array = new int[res.size()][]; for(int i = 0; i <
		 * res.size(); i++) { List<Integer> aaa = res.get(i); int[] a = new int[2]; a[0]
		 * = aaa.get(0); a[1] = aaa.get(1); array[i] = a; } return array;
		 */
		
		 Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
	        LinkedList<int[]> merged = new LinkedList<>();
	        for (int[] interval : intervals) {
	            // if the list of merged intervals is empty or if the current
	            // interval does not overlap with the previous, simply append it.
	            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
	                merged.add(interval);
	            }
	            // otherwise, there is overlap, so we merge the current and previous
	            // intervals.
	            else {
	                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
	            }
	        }
	        return merged.toArray(new int[merged.size()][]);
	}
	
	public static int[][] sortArr(int[][] arr) {
		java.util.Arrays.sort(arr, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		    	return Integer.compare(a[0], b[0]);
		    }
		});
		return arr;
	}

}
