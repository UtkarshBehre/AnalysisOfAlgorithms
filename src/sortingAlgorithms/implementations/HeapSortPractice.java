package sortingAlgorithms.implementations;

public class HeapSort {

	/**
	 * logic to heapify an array
	 * Time Complexity: O(logn)
	 * @param arr
	 * @param n = size of array or last index until which heapify should be done
	 * @param i = element to start heapify on
	 */
	public static void heapify(int[] arr, int n, int i){
		int l = 2*i+1;
		int r = 2*i+2;
		int largest = i; // initialize largest as i (mostly root or point where last heapify took place)
		
		// set largest index based on left or right child being larger
		if(l<n && arr[l] > arr[largest])
			largest = l;
		if(r<n && arr[r] > arr[largest])
			largest = r;
		
		// if largest index got changed above
		// swap and do recursive call to heapify the affected subtree 
		if(largest != i){
			int temp = arr[largest];
			arr[largest]= arr[i];
			arr[i] = temp;
			heapify(arr, n, largest);
		}
	}
	
	/**
	 * logic of heap sort algorithm
	 * first heapify the given array
	 * then loop through last 
	 * Time Complexity: O(nlogn)
	 * @param arr
	 */
	public static void heapSort(int[] arr){
		int n = arr.length;
		// heapify first
		for(int i = n/2 -1 ; i >= 0; i--)
			heapify(arr,n,i);
		
		// swap first element to last while reverse looping
		// because first element will always become largest after heapify
		// we pass i as array size each time, so it'll ignore elements after that in heapify process
		for(int i = n-1; i >=0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr,i,0);
		}
	}
	
	// tester code
	public static void main(String[] args){
		int[] arr = { 8,7,6,5,4,3,2,1};
		heapSort(arr);
		printArr(arr);
	}

	private static void printArr(int[] arr) {
		for(int i : arr)
			System.out.print(i+" ");
	}
}

