package com.amazon.sde2;

public class SortedMartixSearch {

	public static void main(String[] args) {
		int[][] mat = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
		
		search(mat, 4, 150);
	}
	
	public static void search(int[][] arr, int n, int num) {
		for(int i = 0; i < n; ) {
			for(int j = n-1; j >= 0 && i < n; ) {
				if(arr[i][j] == num) {
					System.out.println("Found num at " + i + " " + j + " Position");
					return;
				} else if(arr[i][j] > num) {
					j--;
				} else {
					i++;
				}
				
			}
		}
		System.out.println("Could not find the num");
	}

}
