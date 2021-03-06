package sortingAlgorithms.implementations;

public class InsertionSortPractice {
	
	/**
	 * logic for insertion sort algorithm
	 * loop starts from 0 index and goes until last, key being element at index
	 * within loop a reverse loop goes to start to find right place for element
	 * while going to start we keep assigning right element to left
	 * once outside inner loop assign key to last index point of inner array
	 * Time Complexity: O(n^2)
	 * @param arr
	 */
	public static void insertionSort(int[] arr) {
		
		// loop in ascending order
		for(int i = 0; i<arr.length;i++) {
			int j = i-1;
			int key = arr[i];
			/*	loop in descending order from current i key 
				to the starting or until minimum is reached as left side will be sorted
				Move elements of arr[0..i-1], that are 
            	greater than key, to one position ahead 
            	of their current position */
			while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
		}
	}
	
	// prints array
	static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		insertionSort(arr); 	
		printArray(arr);
	}
}
