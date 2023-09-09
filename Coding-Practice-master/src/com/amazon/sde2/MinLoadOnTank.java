package com.amazon.sde2;

import java.util.Scanner;

public class MinLoadOnTank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {20000,50000};
		System.out.println(getMinTankLoad(arr, 2, 6));
	}
	
	public static double getMinTankLoad(int[] arr, int n, int tanks) {
		int totalSum = 0;
		double tank = tanks;
		for(int i = 0; i < n; i++) {
			totalSum += arr[i];
		}
		
		double maxValue = Double.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			if(tanks <= 0) {
				System.out.println("Tanks over");
			}
			int bSize = arr[i];
			double batalian = bSize;
			double propertion = Math.floor((batalian/totalSum) * 10);
			System.out.println("Proportaion ::: " + propertion + "bsize : " + bSize + " totalSum ::: " + totalSum);
			if(propertion < 1) {
				propertion = 1;
			}
			double load = Math.floor(tank * propertion/100.0 );
			System.out.println("Load ::: " + load + " tank ::  " + tank);
			//tanks -= Math.floor(propertion);
			if(maxValue < load) {
				maxValue = load;
			}
		}
		return maxValue;
	}

}
