package sortingAlgorithms.implementations;

public class BucketSortPractice {
	
	/**
	 * made a class to represent a bucket which can have list of doubles
	 * @author Utkarsh Behre
	 *
	 */
	public static class Bucket{
		public double[] list;
		
		public void insert(double d){
			if(list.length >0){
				for(int i=0; i<list.length; i++){
					if(list[i] ==0){
						list[i] = d;
						break;
					}
				}
			}
		}
	}
	
	/**
	 * logic of bucket sort algorithm
	 * we store the elements according to first digits and index
	 * as this is used to sort double elements
	 * for each bucket(array element) we have a list to store all the doubles
	 * starting with that index
	 * then we sort each individual lists for each array element
	 * finally we put this in the array in order to get sorted array
	 * Time Complexity: O(n) if uniformly distributed elements
	 * @param arr
	 */
	static void bucketSort(double[] arr){
		int min = 0;
		int max = 0;
		for(int i = 0; i<arr.length; i++){
			min = Math.max(max, (int)(arr[i]*10));
			max = Math.max(max, (int)(arr[i]*10));
		}
		//int range = max - min +1;
		Bucket[] buckets = new Bucket[max+1];
		// initiallize individual bucket class
		for(int i=0; i<buckets.length; i++)
			buckets[i] = new Bucket();
		
		// make count to get size of lists needed
		int[] count = new int[10];
		for(int i=0; i<arr.length; i++){
			count[(int)(arr[i]*10)]++;
		}
		
		// initialize the buckets' lists with proper size using count
		for(int i=0; i<max+1; i++){
			buckets[i].list = new double[count[i]];
		}
		
		// set all elements in the buckets
		for(int i=0; i<arr.length; i++){
			buckets[(int)(arr[i]*10)].insert(arr[i]);
		}
		
		// now sort each inner list in the buckets
		for(int i=0; i<buckets.length; i++){
			selectionSort(buckets[i].list);
		}
		
		// now assign buckets elements 1 by 1 to original array
		int k =0;
		for(int i=0; i<buckets.length; i++){
			for(int j=0; j<buckets[i].list.length; j++){
				arr[k] = buckets[i].list[j];
				k++;
			}
		}
		
	}
	
	/**
	 * logic for selection sort used for double array
	 * @param arr
	 */
	static void selectionSort(double[] arr){
		int n = arr.length;
		
		for(int i = 0; i<n; i++){
			int min = i;
			for(int j = min; j<n; j++){
				if(arr[j] < arr[min])
					min = j;	
			}
			double temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	// tester
	public static void main(String[] args){
		double[] arr = {0.22,0.43,0.13,0.912,0.04,0.94,0.63,0.41};
		bucketSort(arr);
		printArr(arr);
	}
	
	// prints array
	static void printArr(double[] arr){
		for(double d: arr)
			System.out.print(d+" ");
	}
}


