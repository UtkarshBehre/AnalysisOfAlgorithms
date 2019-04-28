package sortingAlgorithms.implementations;

public class BinaryInsertionSortPractice {
	// tester
	public static void main(String[] args) {
		int[] arr = {32,53,23,62,1,36,3,5,0};
		System.out.print("Before sorting: ");
		printArr(arr);
		binaryInsertionSort(arr);
		System.out.print("After sorting: ");
		printArr(arr);
	}
	
	/**
	 * logic is similar to insertion sort except
	 * instead of using inner for loop to find right position
	 * we use binary search to find the correct index k of element to insert
	 * once correct index found, we move elements to right and put it at k
	 * running time: O(nlogn) but still O(n^2) for worst case of swapping
	 */
	static void binaryInsertionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int curEle = arr[i];
			int k = findRightPosition(arr,i);
			// move all elements to right to make space at k
			for(int j = i; j>k; j--) {
				arr[j] = arr[j-1];
			}
			arr[k] = curEle;
		}
	}
	
	/**
	 * uses modified binary search to find right position for element at old
	 * running time: O(logn)
	 * @param arr = given array
	 * @param old = old index for the current element to be inserted
	 * @return new position of the current element to be inserted
	 */
	static int findRightPosition(int[] arr, int old) {
		int l = 0;
		int r = old-1;
		if(r == -1)
			return l;
		while(l<=r) {
			if (arr[l] >= arr[old])
				return l;
			int m = l+(r-l)/2;
			
			if(arr[m] < arr[old])
				l = m+1;
			else
				r = m-1;
		}
		return l;
	}
	
	static void printArr(int[] arr) {
		for(int num : arr)
			System.out.print(num+" ");
		System.out.println();
	}

}
