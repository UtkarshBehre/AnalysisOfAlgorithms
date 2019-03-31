package sortingAlgorithms.implementations;


public class MergeSortPractice {
	
	/**
	 * logic for merge sort algorithm
	 * divide and conquer by 2 until we get 2 sorted subarays then sort them
	 * do above recursively
	 * Time Complexity: O(nlogn);
	 * @param arr
	 */
	public static void mergeSort(int[] arr) {
		int l = 0;
		int u = arr.length-1;
		int mid = l+ (u-l)/2;
		if(u>l) {
			
			// make first sub array for left half and call merge sort on it
			int[] array1 = new int[mid+1-l];
			for(int i = 0; i<array1.length; i++)
				array1[i] = arr[l+i];
			mergeSort(array1);
			
			// make second sub array for the right half and call mergeSort on it
			int[] array2 = new int[u-mid];
			for(int i = 0; i<array2.length; i++)
				array2[i] = arr[mid+i+1];
			mergeSort(array2);
			
			// merge the 2 sorted arrays we get from above steps
			int[] mArr = mergeSortedArrays(array1, array2);
			// reset the array at the parameter reference
			for(int i=0; i<mArr.length; i++)
				arr[i] = mArr[i];
			
		}
	}
	
	/**
	 * Merges 2 sorted arrays into 1 and returns it
	 * @param arr1
	 * @param arr2
	 * @return new merged sorted array
	 */
	public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int len = arr1.length+arr2.length;
		int[] arr = new int[len];
		int e1 = 0;
		int e2 = 0;
		int i = 0;

		// copy elements from both arrays until either array gets emptied
		while(e1<arr1.length && e2<arr2.length) {
			// copy the appropriate element among the 2 for sorting
			if(arr1[e1] < arr2[e2])
				arr[i++] = arr1[e1++];
			else
				arr[i++] = arr2[e2++];
		}
		
		// copy the remaining elements of array 1 if any left
		while(e1< arr1.length) 
			arr[i++] = arr1[e1++];
		//copy the remaining elements of array 2 if any left
		while(e2 < arr2.length)
			arr[i++] = arr2[e2++];
		return arr;
	}
	
	// prints a given array
	public static void printArray(int[] arr){
		for(int i: arr){
			System.out.print(i+" ");
		}
	}
	
	// tester
	public static void main(String[] args) {
		int[] arr = {5,4,4,3,2,5,1};
		mergeSort(arr);
		printArray(arr);
	}
}
