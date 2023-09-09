package com.leetcode.dynamic.programming;

import java.util.ArrayList;

public class VowelStringCount{
	
	
	public static void main(String[] args) {
		System.out.println(countVowelStrings(4));

	}

	static ArrayList<Node> stringCounts = new ArrayList<Node>();
    public static int countVowelStrings(int n) {
		    	
		    	if(stringCounts.size() >= n) {
		    		return stringCounts.get(n).totalStrings;
		    	}
		    	else {
		    		if(stringCounts.size()==0) {
			    		 Node firstNode = new Node();
			    		 firstNode.totalStrings =5;
			    		 firstNode.arr = new int[]{1,1,1,1,1};
			    		 stringCounts.add(firstNode);
			    	}
		    		Node calculated = stringCounts.get(stringCounts.size()-1);
	                if(n==1){
	                    return calculated.totalStrings;
	                }
		    		while(stringCounts.size()<n) {
		    			Node processing = new Node();
		    			processing.arr[0]=calculated.totalStrings;
	                    int sum =processing.arr[0];
			    		for(int i=1,j=0;i<5;i++,j++) {
			    			processing.arr[i]=processing.arr[i-1]-calculated.arr[j];
	                        sum += processing.arr[i];
			    		}
	                    processing.totalStrings = sum;
			    		stringCounts.add(processing);
			    		calculated = processing;
		    		}
		    		return calculated.totalStrings;
			    	
		    	}
		        
		    }
		    
		    static class Node{
		        int totalStrings;
		        int arr[] = new int[5];
		    }
	}

