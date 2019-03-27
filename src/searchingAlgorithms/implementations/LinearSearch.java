package searchingAlgorithms.implementations;

/**
 * Java implementation of the Linear Search approach 
 * Worst case O(n)
 * best case O(1)
 * @author Utkarsh
 *
 */
public class LinearSearch {

	// Linearly search x in arr[]. If x is present then return the index, 
	// otherwise return -1 
	static int search(int arr[], int x) { 
		int i; 
		for (i = 0; i < arr.length; i++) { 
			if (arr[i] == x) { 
				return i; 
			} 
		} 
		return -1; 
	} 

	/* Driver program to test above functions*/
	public static void main(String[] args) { 
		int arr[] = {1, 10, 20, 30, 15}; 
		int x = 10;  
		System.out.printf("%d is present at index %d", x, search(arr, x)); 

	} 

}
