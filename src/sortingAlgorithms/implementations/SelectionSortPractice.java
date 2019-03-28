package sortingAlgorithms.implementations;

public class SelectionSortPractice {
	
	/**
	 * logic for selection sort algorithm
	 * find min in unsorted array/subarray and switch it with left most element
	 * then do the same for remaining subarray until last element is reached
	 * Time Complexity: O(n^2)
	 * @param arr
	 * @return
	 */
	public static void selectionSort(int[] arr){
		
		int len = arr.length; 
		int min = 0; //indicates minimum integer's index
		// outer loop to keep left sorted subarray seperate
		for(int p =0; p<len; p++){
			min = p;
			// inner loop to find min in right unsorted subarray 
			for(int i = p; i<arr.length; i++){
				// update the index of min int found
				if(arr[min] > arr[i]){
					min = i;
				}
			}
			// swap
			int temp = arr[p];
			arr[p] = arr[min];
			arr[min] = temp;
		}
	}
	
	// prints an array
	public static void printArray(int[] arr){
		for(int i : arr){
			System.out.print(i+" ");
		}
	}
	
	// tester
	public static void main(String[] args){
		int[] arr = {1,22,3,45,33,22};
		selectionSort(arr);
		printArray(arr);
	}
}
