package sortingAlgorithms.implementations;


public class MergeSortPractice {
	public static void mergeSort(int[] arr, int l, int u) {
		int len = arr.length;
		int mid = l+ (u-l)/2;
		if(u>l) {
			int[] array1 = new int[mid-l];
			System.arraycopy(arr, l , array1, mid, mid-l);
			mergeSort(arr, l, mid);
			int[] array2 = new int[u-mid];
			System.arraycopy(arr, mid+1, array2, u, u-mid);
			mergeSort(array2,mid+1, u);
			arr = mergeSortedArrays(array1, array2);
			
		}
	}
	
	public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int len = arr1.length+arr2.length;
		int[] arr = new int[len];
		for(int i = 0; i<len; i++) {
			int e1 = 0;
			int e2 = 0;
			if(arr1[e1]<arr2[e2]) {
				arr[i] = arr1[e1];
				e1++;
			}
			else if(arr1[e1]<arr2[e2]) {
				arr[i] = arr2[e2];
				e2++;
			}
			else {
				arr[i++] = arr1[e1];
				arr[i] = arr1[e2];
				e1++;e2++;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {6,4,3,2,1};
		mergeSort(arr, 0, arr.length -1);
	}
}
