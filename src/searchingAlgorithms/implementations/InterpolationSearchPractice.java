package searchingAlgorithms.implementations;

public class InterpolationSearchPractice {
	
	/**
	 * logic for interpolation search algo
	 * probe position formula: pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]
	 * Time Complexity: O(n) | if array is uniformly distributed O(loglogn)
	 * @param arr
	 * @param x
	 * @return
	 */
	public static int interpolationSearch(int[] arr, int x){
		int l = 0;
		int u = arr.length -1;
		
		// keep looping until its not possible to get x
		while(u>=l && x>arr[l] && x<arr[u]){
			// avoid divide by zero for single element array
			int pos = 0;
			// apart from finding pos, the remaining logic is same as binary search
			if(u>0)
				pos = l + (((x-arr[l])*(u-l))/(arr[u]-arr[l]));
			if(x == arr[pos])
				return pos;
			if (x < arr[pos])
				u = pos-1;
			else
				l = pos+1;
		}
		
		return -1;
	}
	
	// test the search
	public static void main(String[] args){
		int[] arr = {1};
		int x = 1;
		int index = interpolationSearch(arr,x);
		if(index == -1)
			System.out.println("Element is not in the array.");
		else
			System.out.println(x + " is at the index "+index);
	}
}
