package com.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RandomPickIndex {

	private Map<Integer, Numbers> map = new HashMap<Integer, Numbers>();
	
	class Numbers {
		LinkedList<Index> indexes;
		Index head;
		Integer count = 0;
		public Numbers(LinkedList<Index> indexes) {
			this.indexes = indexes;
		}
		
	}
	
	class Index {
		Integer index;
		public Index(int index) {
			this.index = index;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandomPickIndex r = new RandomPickIndex();
		int[] arr = new int[] {1, 2, 3, 3, 3};
		
		r.initialize(arr);
		int index1 = r.pick(3);
		int index2 = r.pick(1);
		int index3 = r.pick(3);
		int index4 = r.pick(3);
		
		System.out.println(index1 + " " + index2 + " " + index3 + "  " + index4);
		
	}
	
	public void initialize(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int curNum = arr[i];
			if(map.containsKey(curNum)) {
				Numbers numbers = map.get(curNum);
				Index curIndex = new Index(i);
				numbers.indexes.add(curIndex);
				map.put(curNum, numbers);
			} else {
				LinkedList<Index> indexes= new LinkedList<Index>();
				Index index  = new Index(i);
				indexes.add(index);
				Numbers numbers = new Numbers(indexes);
				map.put(curNum, numbers);
			}
		}
	}
	
	public int pick(int target) {
      
		Numbers numbers = map.get(target);
		if(numbers.count >= numbers.indexes.size()) {
			numbers.count = 0;
		}
		Integer curIndex = numbers.indexes.get(numbers.count).index;
		numbers.count = numbers.count + 1;
		return curIndex;
    }

}
