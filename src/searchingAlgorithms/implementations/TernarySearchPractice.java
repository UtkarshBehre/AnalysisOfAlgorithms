package searchingAlgorithms.implementations;

public class TernarySearchPractice {
	
	/**
	 * logic for ternary search algorithm
	 * divide the given array into more than 2 parts 
	 * then compare numbers in parts just like in binary search but with multiple mid points
	 * time complexity: logn | log n with base 3 in below case
	 * @param arr
	 * @param l
	 * @param u
	 * @param x
	 * @return
	 */
	public static int ternarySearch(int[] arr, int l, int u, int x) {
		
		while(u>=l) {
			// need 2 mid points to divide the array into 3 parts
			int m1 = l + (u-l)/3;
			int m2 = m1+ (u-l)/3;
			
			//compare both mid points
			if(arr[m1] == x)
				return m1;
			if(arr[m2] == x)
				return m2;
			// find the part that could have the element
			if(arr[m1] > x)
				u = m1-1;
			else if(arr[m2] < x)
				l = m2+1;
			else {
				l = m1+1;
				u = m2-1;
			}
		}
		return -1;
	}
	
	// tester
	public static void main(String[] args) {
		int[] arr = {8,9};
		int x = 8;
		int index = ternarySearch(arr, 0, arr.length-1, x);
		System.out.println(index);
	}
}
