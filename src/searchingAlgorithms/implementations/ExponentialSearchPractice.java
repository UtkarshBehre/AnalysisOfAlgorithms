package searchingAlgorithms.implementations;

public class ExponentialSearchPractice {
	
	/**
	 * logic for exponential search algorithm
	 * find range by jumping block size *2 every time
	 * then apply binary search on the range number found.
	 * @param arr
	 * @param x
	 * @return
	 */
	public static int exponentialSearch(int[] arr, int x){
		int len = arr.length;
		// handle first element match 
		if(len >= 1 && x == arr[0])
			return 0;
		// handle single element array
		else if ((len == 1 && x != arr[0]) || len == 0)
			return -1;
		int it = 1;
		
		//exponential jumps until element found or jump reaches end
		while(it<len && x > arr[it])
			it*=2;
		return binarySearch(arr, it/2, Math.min(it, len-1), x);
	}
	
	// binary search logic 
	public static int binarySearch(int[] arr, int l, int u, int x) {
		while(u>=l){
			int m = l + (u-l)/2;
			if(arr[m] == x)
				return m;
			if(arr[m] > x)
				u = m-1;
			else
				l = m+1;
		}
		return -1;
	}
	
	// tester
	public static void main(String[] args){
		int[] arr = {1,3,5,7,8,90,93};
		int x = 93;
		int index = exponentialSearch(arr, x);
		System.out.println(index);
	}
}
