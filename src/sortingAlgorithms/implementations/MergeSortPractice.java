package sortingAlgorithms.implementations;


public class MergeSortPractice {
	public static void mergeSort(int[] arr, int l, int u) {
		l = 0;
		u = arr.length-1;
		int len = arr.length;
		int mid = l+ (u-l)/2;
		if(u>l) {
			int[] array1 = new int[mid+1-l];
			for(int i = 0; i<array1.length; i++){
				array1[i] = arr[l+i];
			}
			mergeSort(array1, l, mid);
			int[] array2 = new int[u-mid];
			for(int i = 0; i<array2.length; i++){
				array2[i] = arr[mid+i+1];
			}
			
			mergeSort(array2,mid+1, u);
			int[] mArr = mergeSortedArrays(array1, array2);
			for(int i=0; i<mArr.length; i++){
				arr[i] = mArr[i];
			}
			
		}
	}
	
	public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int len = arr1.length+arr2.length;
		int[] arr = new int[len];
		int e1 = 0;
		int e2 = 0;
		for(int i = 0; i<len; i++) {
			
			if(e1<arr1.length && e2<arr2.length){
				if(arr1[e1] < arr2[e2]){
					arr[i] = arr1[e1];
					e1++;
				}else{
					arr[i] = arr2[e2];
					e2++;
				}
			}
			else if(e1>=arr1.length && e2<arr2.length){
				arr[i] = arr2[e2++];
			} else if(e2>=arr2.length && e1<arr1.length){
				arr[i] = arr1[e1++];
			}
		}
		return arr;
	}
	
	public static void printArray(int[] arr){
		for(int i: arr){
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6,4,3,2,1};
		mergeSort(arr, 0, arr.length -1);
		printArray(arr);
	}
}
