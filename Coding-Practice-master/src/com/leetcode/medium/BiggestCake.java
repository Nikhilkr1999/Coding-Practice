package com.leetcode.medium;

import java.util.Scanner;

public class BiggestCake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int h = 5, w = 4;
		int[] horizontalCuts = new int[] {3, 1};
		int[] verticalCuts = new int[] {1};
		System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
	}

	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Integer max = Integer.MIN_VALUE;
        //horizontalCuts[horizontalCuts.length] = h;
        //verticalCuts[verticalCuts.length] = w;
        
        int maxHorizontal = Integer.MIN_VALUE;
        int maxVertical = Integer.MIN_VALUE;
        
        if(horizontalCuts.length == 1) {
        	maxHorizontal = h - horizontalCuts[0] > horizontalCuts[0] ? h - horizontalCuts[0] :  horizontalCuts[0];
        }
        
        if(verticalCuts.length == 1) {
        	maxVertical = w - verticalCuts[0] > verticalCuts[0] ? w - verticalCuts[0] : verticalCuts[0]; 
        }
        for(int i = 0; i < horizontalCuts.length - 1; i++) {
        	int diff = horizontalCuts[i] - horizontalCuts[i+1];
        	diff = diff < 0 ? -diff : diff;
        	if(diff > maxHorizontal) {
        		maxHorizontal = diff;
        	}
        }
        
        for(int i = 0; i < verticalCuts.length - 1; i++) {
        	int diff = verticalCuts[i] - verticalCuts[i+1];
        	diff = diff < 0 ? -diff : diff;
        	if(diff > maxVertical) {
        		maxVertical = diff;
        	}
        }
        
        max = maxVertical * maxHorizontal;
        
        
        return max;
    }
}
