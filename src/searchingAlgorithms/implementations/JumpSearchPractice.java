package searchingAlgorithms.implementations;

public class JumpSearchPractice {
	
	/**
	 * logic for jump search algorithm 
	 * jumps for sqrt of length of array until the block is found then performs linear search
	 * Time Complexity : O(sqrt of n)
	 * Auxiliary Space : O(1)
	 * @param arr = given array
	 * @param step = block size to jump each step
	 * @param x = number to find
	 * @return
	 */
	public static int jumpSearch(int[] arr, int x){
		
		int step = (int)Math.floor(Math.sqrt(arr.length));
		int old= 0;
		for(int i = 0; i < arr.length; i+= step){
			
			if(x < arr[i]){
				break;
			}
			old = i;
		}

		for(int j = old; j < arr.length; j++){
			if(x == arr[j])
				return j;
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int x = 4;
		int index = jumpSearch(arr, x);
		//int index = jumpSearch1(arr, x);
		if(index == -1)
			System.out.println(x + " is not present in the array.");
		else
			System.out.println(x + " is present at index "+ index +".");
	}
}
