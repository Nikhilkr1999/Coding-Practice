package com.amazon.sde2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GoldMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		GoldMine gm = new GoldMine();
		
		Gold[][] goldMatrix = new Gold[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int totalGold = sc.nextInt();
				Gold g = gm.new Gold(i, j, totalGold);
				goldMatrix[i][j] = g;
			}
		}
		int totalGold = getTotalGold(goldMatrix, n, 0, 0);
		System.out.println(totalGold);
	}
	
	
	public static int getTotalGold(Gold[][] goldMatrix, int n, int row, int col) {
		
		//Gold current = goldMatrix[row][col];
		int fistSum = 0;
		int secondSum = 0;
		int thirdSum = 0;
		//go digonal up
		if(row - 1 >= 0 && col + 1 < n ) {
			if(goldMatrix[row-1][col+1].isVisited == false) {
				fistSum = getTotalGold(goldMatrix, n, row-1, col+1);
			} else {
				fistSum = goldMatrix[row-1][col+1].totalGold;
				System.out.println("First Sum ::: "  + fistSum);
				
			}
		}
		
		
		//go diagonal down
		
		if(row + 1 < n && col + 1 < n ) {
			if(goldMatrix[row+1][col+1].isVisited == false) {
				secondSum = getTotalGold(goldMatrix, n, row+1, col+1);
			} else {
				secondSum = goldMatrix[row+1][col+1].totalGold;
				System.out.println("SecondSum ::: "+ secondSum);
			}
			
		}
		
		//go right
		if(col + 1 < n) {
			if(goldMatrix[row][col+1].isVisited == false) {
				thirdSum = getTotalGold(goldMatrix, n, row, col+1);
			} else {
				thirdSum = goldMatrix[row][col+1].totalGold;
				System.out.println("ThirdSum ::: " + thirdSum);
			}
			
		}
		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(fistSum);
		arr.add(secondSum);
		arr.add(thirdSum);
		Collections.sort(arr);
		goldMatrix[row][col].isVisited = true;
		goldMatrix[row][col].totalGold = goldMatrix[row][col].gold + arr.get(2);
		return goldMatrix[row][col].totalGold;
		
	}
	
	class Gold {
		int i;
		int j;
		int gold;
		int totalGold;
		boolean isVisited = false;
		
		public Gold(int i, int j, int totalGold) {
			this.i = i;
			this.j = j;
			this.gold = totalGold;
			this.totalGold = totalGold;
		}
	}

}
