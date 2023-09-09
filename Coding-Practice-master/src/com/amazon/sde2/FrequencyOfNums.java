package com.amazon.sde2;

public class FrequencyOfNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {0, 2,3,2,3,5};
		populateCountArray(arr, 1, 5, 0);
		processRemianingArray(arr, 5);
		for(int i = 0; i < 6; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void populateCountArray(int[] arr, int i, int finalIndex, int count) {
		if(count >= finalIndex) return;
		if(i >= finalIndex || i < 0) {
			return;
		}
		System.out.println(i + " " + arr[i]);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		if(arr[i] < 0) {
			arr[i]--;
			return;
		} else{
			int temp = arr[i];
			arr[i] = -1;
			populateCountArray(arr, temp, finalIndex, count);
			
		}
	}
	
	public static void processRemianingArray(int[] arr, int i) {
		
		for(; i < arr.length; i++) {
			if(arr[i] > 0) {
				if(arr[arr[i]] > 0) {
					arr[arr[i]] =  -1;
				} else {
					arr[arr[i]]--;
				}
			}
			
		}
	}

}
