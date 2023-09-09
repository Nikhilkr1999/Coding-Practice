package com.leetcode.array.easy;

import java.util.Arrays;
import java.util.Scanner;

public class BuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		/*
		 * int[] arr = new int[n]; for(int i = 0; i < n; i++) { arr[i] = sc.nextInt(); }
		 * Integer totalProfiet = getProfiet(arr);
		 */
		System.out.println(reverse(n));
	}
	
	public int maxProfit(int[] arr) {
		int totalProfiet = 0;
		int buyPrice=-1;
		int sellPrice=-1;
		boolean isBuy = true;
		for(int i = 0; i < arr.length - 1; i++) {
		    if(isBuy) {
			if(arr[i] >= arr[i+1]) {
			    continue;
			}
			buyPrice = arr[i];
			isBuy = false;
		    } else {
			if(arr[i] <= arr[i+1]) {
			    continue;
			}
			sellPrice = arr[i];
			isBuy = true;
			totalProfiet += sellPrice - buyPrice;
			buyPrice = -1;
			sellPrice = -1;


		    }
		}
		if(buyPrice != -1) {
		    totalProfiet += arr[arr.length - 1] - buyPrice;
		}
		return totalProfiet;
	    }
	
	

}
