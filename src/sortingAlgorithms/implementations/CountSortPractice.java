package sortingAlgorithms.implementations;

public class CountSortPractice {
	
	/**
	 * logic for counting sort when there are only positive integers that are not too big
	 * find the max element in the array
	 * make a count array[max+1] and increase the count of a number represented by index of the count array which is present in given array
	 * loop through count array and keep adding last count to current so it represents how many numbers are before current number
	 * then use those numbers by positioning all elements from given array to a new array
	 * finally copy new array back to original array
	 * Time Complexity: O(n)
	 * @param arr
	 */
	static void countSortPos(int[] arr){
		int max = 0;
		int n = arr.length;
		// the sorted array to which we'll copy array elements in proper positions
		int[] sortedArr = new int[n];
		
		if(n>0)
			max = arr[0];
		
		// find the max element
		for(int i = 0; i<n; i++)
			max = Math.max(max, arr[i]);
		
		// make a counting array with max + 1 as max element will be represented by max as int in index
		int[] count = new int[max+1];
		
		// count the distinct elements
		for(int i = 0; i<n; i++)
			count[arr[i]]++;
		
		// find cumulative count that will represent num of elements present before current element
		for(int i = 1; i<count.length; i++)
			count[i] = count[i-1]+count[i];
		
		// find the right position for elements in given array using count and put them in sorted array
		// NOTE: we run reverse loop so that previous sorted order is maintained
		for(int i = n-1; i>=0; i--)
			// actually count value represents 1 more than actual index value as 0 is not included
			sortedArr[--count[arr[i]]-1] = arr[i];
		
		// reassign sorted array to given array
		for(int i =0; i<n; i++)
			arr[i] = sortedArr[i];
	}
	
	/**
	 * logic for count sort algorithm for all integers
	 * this logic remains similar to positive integers only except for below differences
	 * we find min element along with max then find a range
	 * count array is of size range + 1
	 * while incrementing count we subtract any element with min as first element is min
	 * important thing to not here is indices don't represent actual elements of array, but rather relative element ele - min
	 * Time Complexity: O(n+r) where n is size of array and r is range 
	 * @param arr
	 */
	static void countSortRange(int[] arr){
		
		int min = 0;
		int max = 0;
		int n = arr.length;
		
		//
		int[] sortedArr = new int[n];
		if(n>0){
			min = arr[0];
			max = arr[0];
		}
		
		for(int num : arr){
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		
		// make a counting array with the range of elements present +1 to represent last element 
		int range = max - min +1;
		int[] count = new int[range];
		
		// increase count of elements relative to position in count array
		for(int i=0; i<n; i++)
			count[arr[i]-min]++;
		
		// make count cumulative so it represents 
		for(int i=1; i<count.length; i++)
			count[i] += count[i-1];
		
		// assign the element in the right position using count array to the sorted array
		for(int i = n-1; i>=0; i--)
			// actualy count value represents 1 more than actual index value as 0 is not included
			sortedArr[--count[arr[i]-min]] = arr[i];
		
		// assign sorted array to the given array
		for(int i=0; i<n; i++){
			arr[i] = sortedArr[i];
		}
	}
	
	/**
	 * logic for count sort for character array
	 * the logic remains similar to positive integers except here the range is always 256 starting from 0
	 * the indices represent the ASCII values of the characters so parse it wherever necessary
	 * Time Complexity: O(n+r) where n is size of array and r is the range
	 * @param arr
	 */
	static void countSortChar(char[] arr){
		int n = arr.length;
		// sorted array where we'll put the elements in right positions
		char[] sortedArr = new char[n];
		
		// since we need char ascii values we take 256 as range
		int[] count = new int[256];
		
		// count each char
		for(int i=0; i<n; i++)
			count[(int)arr[i]]++;
		
		// add counts to find positions
		for(int i=1; i<count.length; i++)
			count[i] += count[i-1];
		
		// copy elements in right positions using count array
		for(int i = n-1; i>=0; i--)
			// count -1 to consider 0th index
			sortedArr[--count[(int)arr[i]]] = arr[i];
		
		// copy the sorted array to original array
		for(int i=0; i<n; i++)
			arr[i] = sortedArr[i];
			
	}
	
	public static void main(String[] args){
	//	int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10};
	//	int[] arr = {10,74,273,74,28,473,72,26,16,6,95};
		char[] arr = {'y','t','c','g','b','x'};
		//countSortPos(arr);
		//printArr(arr);
		countSortChar(arr);
		for(char c: arr)
			System.out.print(c+" ");
		
		
	}
	
	public static void printArr(int[] arr){
		for(int i: arr)
			System.out.print(i+" ");
	}
}
