package com.amazon.sde2;

import java.util.Arrays;
import java.util.Scanner;

public class Sort012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		 int[] arr = new int[n]; 
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt(); 
		 }
		 
		 sort012ArrNew(arr, n);
	}
	
	public static void sort012ArrNew(int[] a, int n) {
		int lo = 0;
        int hi = n - 1;
        int mid = 0, temp = 0, count = 0;
        while (mid <= hi) {
        	count++;
            switch (a[mid]) {
	            case 0: {
	                temp = a[lo];
	                a[lo] = a[mid];
	                a[mid] = temp;
	                lo++;
	                mid++;
	                break;
	            }
	            case 1:
	                mid++;
	                break;
	            case 2: {
	                temp = a[mid];
	                a[mid] = a[hi];
	                a[hi] = temp;
	                hi--;
	                break;
	            }
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(count);
	}
	
	public static void sort012Arr(int[] arr, int n) {
		
		int zeroIndex = Integer.MAX_VALUE, oneIndex = Integer.MAX_VALUE, twoIndex = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] == 0) {
				zeroIndex = i;
			} else if(arr[i] == 1 ) {
				oneIndex = i;
			} else if(arr[i] == 2 ){
				twoIndex = i;
			}
			if(zeroIndex != Integer.MAX_VALUE && oneIndex != Integer.MAX_VALUE && twoIndex != Integer.MAX_VALUE) {
				break;
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(zeroIndex + " ::: " + oneIndex + " ::: " + twoIndex);
			if(arr[i] == 0 && i < zeroIndex) {
				zeroIndex = i;
			} else if(arr[i] == 1 && i < oneIndex) {
				oneIndex = i;
			} else if(arr[i] == 2 && i < twoIndex){
				twoIndex = i;
			}
			//if(zeroIndex != -1 && oneIndex != -1 && twoIndex != -1) {
				if(oneIndex < zeroIndex ) {
					System.out.println(zeroIndex + " : " + oneIndex);
					arr[oneIndex] = 0;
					arr[zeroIndex] = 1;
					int temp = oneIndex;
					oneIndex = zeroIndex;
					zeroIndex = temp;
				}
				
				if(twoIndex < oneIndex ) {
					System.out.println(oneIndex + " :: " + twoIndex);
					arr[twoIndex] = 1;
					arr[oneIndex] = 2;
					int temp = twoIndex;
					twoIndex = oneIndex;
					oneIndex = temp;
				}
			//}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort012(int[] arr, int n) {
		int zeroIndex = -1, oneCount = 0, oneIndex = -1, twoIndex = n-1;
		for(int i = 0; i < n; i++) {
			int curNum = arr[i];
			if(curNum == 0) {
				zeroIndex = i;
				if(zeroIndex > oneIndex && oneIndex != -1) {
					arr[oneIndex] = 0;
					arr[i] = 1;
					oneIndex = i;
				}
			} else if(curNum == 1) {
				oneIndex = i;
				oneCount++;
			} else {
				int twoIndexVal = arr[twoIndex];
				if(twoIndexVal == 1) {
					oneCount++;
					arr[twoIndex] = 2;
					twoIndex--;
				} else if(twoIndexVal == 0) {
					arr[i] = 0;
					arr[twoIndex] = 2;
					twoIndex--;
					zeroIndex = i;
				} else {
					while(arr[twoIndex] == 2 && twoIndex >= 0) {
						twoIndex--;
					}
					if(arr[twoIndex] == 1) {
						oneCount++;
						arr[twoIndex] = 2;
						twoIndex--;
					} else {
						arr[i] = 0;
						arr[twoIndex] = 2;
						zeroIndex = i;
					}
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		
		for(int i = zeroIndex + 1; i < twoIndex; i++) {
			arr[i] = 1;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
