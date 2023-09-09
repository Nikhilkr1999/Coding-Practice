package com.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[][] arr = new int[][] {{1,3},{-2,2}};
		KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
		int[][] res = obj.kClosest(arr, 1);
		System.out.println(Arrays.deepToString(res));
	}
	
	class Points{
		int x;
		int y;
		double distance;
		
		public Points(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Points(int x, int y, double distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
		
	}
	
	public int[][] kClosest(int[][] points, int k) {
        Points[] pointsArr = new Points[points.length];
		if(points.length == k) {
			return points;
		}
		
		int[][] shortestPoints = new int[k][2];
		
		for(int i = 0; i < points.length; i++) {
			int[] point = points[i];
			
			double distance = Math.sqrt(Math.pow((0-point[0]), 2) + Math.pow((0-point[1]), 2));
			Points p = new Points(point[0], point[1], distance);
			pointsArr[i] = p;
		}
		
		Arrays.sort(pointsArr, new Comparator<Points>() {
			@Override
			public int compare(Points o1, Points o2) {
				if(o1.distance > o2.distance) {
					return 1;
				} else if( o1.distance < o2.distance){
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		for(int i = 0; i < k; i++) {
			//System.out.println(pointsArr[i].x + " " + pointsArr[i].y + " " + pointsArr[i].distance);
			shortestPoints[i] = new int[] {pointsArr[i].x, pointsArr[i].y };
		}
		
		return shortestPoints;
    }
	
	

}
