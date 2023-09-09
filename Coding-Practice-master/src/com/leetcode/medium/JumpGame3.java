package com.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canReach(int[] arr, int start) {
        int length = arr.length;
        Queue<Integer> indexQueue = new LinkedList<Integer>();
        Set<Integer> visitedIndex = new HashSet<Integer>();
        indexQueue.add(start);
        visitedIndex.add(start);
        
        while(!indexQueue.isEmpty()) {
            int curIndex = indexQueue.poll();
            if(arr[curIndex] == 0) {
                return true;
            }
            
            int leftChildIndex = curIndex - arr[curIndex];
            if(leftChildIndex >= 0 && !visitedIndex.contains(leftChildIndex)) {
                if(arr[leftChildIndex] == 0) {
                    return true;
                }
                visitedIndex.add(leftChildIndex);
                indexQueue.add(leftChildIndex);
            }
            int rightChildIndex = curIndex + arr[curIndex];
            if(rightChildIndex < length && !visitedIndex.contains(rightChildIndex)) {
                if(arr[rightChildIndex] == 0) {
                    return true;
                }
                visitedIndex.add(rightChildIndex);
                indexQueue.add(rightChildIndex);
            }
        }
        return false;
    }
}
