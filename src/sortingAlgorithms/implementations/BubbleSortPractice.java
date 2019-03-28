package sortingAlgorithms.implementations;

public class BubbleSortPractice {
	
	/**
	 * logic for bubble sort algorithm
	 * compares adjacent elements and swaps if left is bigger until end is reached
	 * repeat above until the last sorted end point from right is reached
	 * Time Complexity: O(n^2)
	 * @param arr
	 * @return
	 */
	public static void bubbleSort(int[] arr){
		// keep decreasing end point for highest sorted numbers
		for(int last = arr.length-1; last>=0; last--){
			// loop until next element is not last
			for(int i = 0; i+1<=last; i++){
				// swap if left is higher
				if(arr[i] > arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}	
		}
	}
	
	// prints an array
	public static void printArr(int[] arr){
		for(int i : arr)
			System.out.print(i+" ");
	}
	
	// tester
	public static void main(String[] args){
		int[] arr = {5,4,33,2,1,56};
		bubbleSort(arr);
		printArr(arr);
	}
}
