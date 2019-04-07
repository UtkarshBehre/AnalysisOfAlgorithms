package sortingAlgorithms.implementations;

public class RadixSortPractice {

	/**
	 * logic for radix sort algorithm
	 * find the max element
	 * loop until we get a value more than 0 when divided by 1 or multiple of 10
	 * call countSort in the loop passing the current value of divide checker
	 * Time Complexity: O(d*(n+r)) where d is number of digits, n is number of elements, r is range
	 * outer loop is run d times(3 in this case) and inner loops run either n times or r times(10 in this case) 
	 * @param arr
	 */
	static void radixSort(int[] arr){
		// assuming only positive numbers
		int max = 0;
		int n = arr.length;
		// find the max element
		for(int i=0; i<n; i++)
			max = Math.max(max, arr[i]);

		// i starting with 1 used to divide element by appropriate 10^i so %10 gives the correct unit, tenth or so digit
		// used for sorting using count sort
		for(int i=1; max/i >0; i*=10 )
			countSort(arr,i);
	}
	
	/**
	 * logic for slightly modified count sort algorithm 
	 * uses div number to arrange integers using one of the digit of elements at the same place like unit or tenth digit
	 * @param arr
	 * @param div
	 */
	static void countSort(int[] arr, int div){
		int n = arr.length;
		// use to put elements in right positions
		int[] sortedArr = new int[n];
		int[] count = new int[10];
		
		// store the count of each element's current digit
		// eg unit digit of 28 and 428 would be same so it'll be considered distinct
		for(int i=0; i<n; i++)
			count[arr[i]/div%10]++;
		
		// add the counts to find out how many elements are present before current one
		for(int i=1; i<count.length; i++)
			count[i] += count[i-1];
		
		// NOTE: we run reverse loop so that previous sorted order is maintained
		for(int i=n-1; i>=0; i--)
			// put element from array in right position in sorted array using the current digit's position in count
			sortedArr[--count[arr[i]/div%10]] = arr[i]; 
		
		// assign the sorted array back to original array
		for(int i=0; i<n; i++)
			arr[i] = sortedArr[i];
	}
	
	// tester
	public static void main(String[] args){
		int[] arr = {83,23,4,583,237,483,651,639,751};
		radixSort(arr);
		printArr(arr);
	}
	
	// prints a given integer array
	static void printArr(int[] arr){
		for(int i : arr)
			System.out.print(i+" ");
	}
}
