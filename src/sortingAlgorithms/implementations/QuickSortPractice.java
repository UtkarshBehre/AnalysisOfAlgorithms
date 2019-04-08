package sortingAlgorithms.implementations;

public class QuickSortPractice {
	
	/**
	 * logic for quick sort algorithm |
	 * 
	 * find pivot in a given array, could be first, last, mid, or random index
	 * loop through the items, always ignoring the pivot index.
	 * maintain i index for elements smaller than pivot element.
	 * if current element is lower then pivot inc i according to pivot index 
	 * then swap ith element with current element.
	 * end of loop.
	 * now swap ith or i+1th element with pivot based on pivot being < or > i.
	 * finally recall itself for the 2 divided parts by the pivot element's final position;
	 * |
	 * Time Complexity: Worst case: O(n^2), Average case: O(nlogn) 
	 * @param arr = given array
	 * @param l = left most index
	 * @param r = right most index
	 */
	public static void quickSort(int[] arr, int l, int r){
		if(l<r){
			// get the corrected pivot element position
		//	int pi = partitionUsingFirst(arr, l, r);
		//	int pi = partitionUsingLast(arr,l,r);
		//	int pi = partitionUsingMid(arr,l,r);
			int pi = partitionUsingRandom(arr, l, r);

			quickSort(arr, l, pi-1);
			quickSort(arr, pi+1, r);		
		}
	}
	
	/**
	 * logic for quickSort algorithm using iterative approach
	 * uses stack concept to carry left and right indexes so that functionality is same as recursive approach
	 */
	public static void quickSortIterative(int[] arr, int l, int r) {
		int[] stack = new int[arr.length];
		int top = -1;

		stack[++top] = l;
		stack[++top] = r;

		while(top >=0) {
			r = stack[top--];
			l = stack[top--];
			
			if(l>r)
				return;
			int pi = partitionUsingLast(arr, l, r);
			if(pi-1 > l) {
				stack[++top] = l;
				stack[++top] = pi-1;
			}
				
			if(pi+1 < r) {
				stack[++top] = pi+1;
				stack[++top] = r;
			}
		}
	}
	
	/**
	 * logic for partitioning using last index as pivot |
	 * in this case we loop through elements excluding last one
	 * we maintain i while swaping each element
	 * since index will always be >= i here 
	 * we directly swap pivot(last) with i+1th
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	public static int partitionUsingLast(int[] arr, int l, int r){
		// start i with 1 less than lower | if initiated with 0 we can get out of bound
		int i = l-1;
		int pivot = r;
		int pivotEle = arr[pivot];
		// skip last element in loop
		for(int j = l; j<r; j++ ){
			// if an element is smaller than pivot element
			if(arr[j]<=pivotEle){
				// inc i coz it is holding the last swapped element or -1 than swap
				i++;
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j] = temp;
			}
		}
		// swap i+1th element with pivot element as pivot is always > i in this case
		arr[pivot] = arr[i+1];
		arr[i+1] = pivotEle;
		// return the new position of the pivot element
		return i+1;
	}
	
	/**
	 * logic for partitioning  using first index as pivot |
	 * since we take 1st element as pivot, we ignore first element instead of last here
	 * so loop starts from second element
	 * and since pivot will always be <= i 
	 * we swap ith element with pivot 
	 * Note: swaping i+1 with pivot would move bigger element left to pivot here, 
	 * which would be wrong
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	public static int partitionUsingFirst(int[] arr, int l, int r){
		// start i with l because we will be skipping this element
		int i = l;
		int pivot = l;
		int pivotEle = arr[pivot];
		// skip first element in loop
		for(int j = l+1; j<=r; j++){
			// inc i coz it is holding the last swapped element or first
			if(arr[j]<=pivotEle){
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		// swap ith element with pivot element as pivot is always < i in this case
		arr[pivot] = arr[i];
		arr[i] = pivotEle;
		// return the new position of the pivot element
		return i;
	}
	
	/**
	 * logic for partitioning using mid index as pivot
	 * this is culmination of first and last index as pivot logics
	 * instead of avoiding first or last, we just avoid the pivot index itself
	 * big difference here is if we have pivot in the middle
	 * then i needs to be incremented 2 times when it is 1 below pivot to avoid touching pivot
	 * after the loop, we need a check to see pivot or i is bigger
	 * then swap i or i+1th element with pivot just like first and last index partitioning
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	public static int partitionUsingMid(int[] arr, int l, int r){
		// start i with -1 as we do not know what first element can be
		int i = l-1;
		int pivot = l+(r-l)/2;
		int pivotEle = arr[pivot];
		// loop through all elements
		for(int j = l; j<=r; j++){
			// skip if current index is pivot  
			// otherwise swap if current element is lower than pivot element
			if(j!=pivot && arr[j]<=pivotEle){
				// if i is 1 less then pivot, we need to inc. i twice to skip pivot index
				if(i==pivot-1)
					i = i+2;
				// otherwise we just inc i once like normal
				else
					i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// swap ith element with pivot element if pivot is < i
		if(pivot < i){
			arr[pivot] = arr[i];
			arr[i] = pivotEle;
		}
		// swap i+1th element with pivot element as pivot is > i
		else if(pivot>i){
			i++;
			arr[pivot] = arr[i];
			arr[i] = pivotEle;
		}
		// return the new position of the pivot element
		return i;
	}
	
	/**
	 * logic for partitioning using random index between first index and last index included
	 * here we take a random index, between first and last included, as pivot
	 * remaining logic is same as mid index partitioning
	 * Note: we can face the case of first,last or mid index partitioning in this case
	 * because random index can be anything
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	public static int partitionUsingRandom(int[] arr, int l, int r){
		int i = l-1;
		// get random number between left and right
		int pivot = genRandom(l,r);
		
		// below logic is same as in mid index partitioning
		int pivotEle = arr[pivot];
		for(int j = l; j<=r; j++){
			if(j!=pivot && arr[j]<=pivotEle){
				if(i==pivot-1)
					i = i+2;
				else
					i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		if(pivot < i){
			arr[pivot] = arr[i];
			arr[i] = pivotEle;
		}
		else if(pivot>i){
			i++;
			arr[pivot] = arr[i];
			arr[i] = pivotEle;
		}
		return i;
	}
	
	/**
	 * generates a random number between low and high 
	 * @param low = lowest allowed integer
	 * @param high = highest allowed integer
	 * @return random number
	 */
	public static int genRandom(int low, int high){
		int digitCount = String.valueOf(high).length();
		int randomNo = high +1;
		while(!(randomNo >= low && randomNo <= high))
			randomNo = (int) Math.floor(Math.random()*(Math.pow(10, digitCount)));
		return randomNo;
	}
	
	// Tester code
	public static void main(String[] args){
		int[] arr = {10,74,273,74,28,473,72,26,16,6,95};
		//quickSort(arr, 0, arr.length-1);
		quickSortIterative(arr, 0, arr.length-1);
		printArr(arr);
		//System.out.println(genRandom(13));
	}

	/**
	 * prints array
	 * @param arr
	 */
	private static void printArr(int[] arr) {
		for(int i : arr){
			System.out.print(i+" ");
		}
	}
}
