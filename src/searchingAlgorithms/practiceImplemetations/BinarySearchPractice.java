package searchingAlgorithms.practiceImplemetations;

public class BinarySearchPractice {
	
	
	/**
	 * recursive binary search logic | 
	 * time complexity: O(logn)
	 * @param arr = array to search in
	 * @param l = lower index
	 * @param u = upper index
	 * @param x = integer to search
	 * @return
	 */
	public static int binarySearchRecursive(int[] arr, int l, int u, int x){
		// check upper is always higher than lower
		if(u >= l){
			int m = l + (u - l)/2;
			// if middle number than just return the index
			if(arr[m] == x)
				return m;
			// if lower than middle number than set upper to middle -1 and recall
			else if(x < arr[m] )
				return binarySearchRecursive(arr, l, m-1, x );
			// else higher than middle number than set lower to middle +1 and recall
			return binarySearchRecursive(arr, m+1, u, x );
		}
		// return -1 if not found in any case
		return -1;
	}
	
	/**
	 * iterative binary search logic
	 * time complexity: O(logn)
	 * @param arr
	 * @param x
	 * @return
	 */
	public static int binarySearchIterative(int[] arr, int x){
		int l = 0;
		int u = arr.length-1;
		
		// run loop until higher index is lower than lower index
		while(u>=l){
			int m = l + (u-l)/2;
			// if it is middle element then return middle index
			if(x == arr[m])
				return m;
			// set upper index to middle -1 if x is lower than middle number
			else if (x < arr[m])
				u = m-1;
			// set lower index to middle +1 if x is higher than middle number
			else
				l = m+1;
		}
		// return -1 if number is not found
		return -1;
	}
	
	// testing the search
	public static void main(String[] args){
		int[] array = {1,2,3,4,5,64,223};
		int x = 223;
		//int index = binarySearchRecursive(array, 0, array.length-1, x);
		int index = binarySearchIterative(array, x);
		if(index == -1)
			System.out.println(x + " is not present at any index");
		else
			System.out.println(x + " is present at index "+index);
	}
}
