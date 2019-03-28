package searchingAlgorithms.implementations;

public class LinearSearchPractice {

	/**
	 * logic for Linear Search algorithm
	 * search linearly from first element to last until the element is found
	 * Worst case O(n)
	 * best case O(1)
	 * @param arr == given array
	 * @param x = integer to search
	 * @return
	 */
	public static int linearSearch(int[] arr, int x) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == x)
				return i;
		}
		return -1;
	}
	
	// test the search
	public static void main(String[] args) {
		int[] arr = {2,5,23,53};
		int x = 6;
		int index = linearSearch(arr,x);
		if(index == -1)
			System.out.println(x+" is not present in the array "+arr);
		else
			System.out.println(x+" is present in the array at index "+index);
	}
	
}
