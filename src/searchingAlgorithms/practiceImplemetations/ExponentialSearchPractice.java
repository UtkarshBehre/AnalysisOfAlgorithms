package searchingAlgorithms.practiceImplemetations;

public class ExponentialSearchPractice {
	
	public static int exponentialSearch(int[] arr, int x){
		int len = arr.length;
		if(len == 1 && x == arr[0])
			return 0;
		else if ((len == 1 && x != arr[0]) || len == 0)
			return -1;
		int it = 1, prev = 1;
		
		while(x > arr[it])
		{
			if(it*2>len){
				it = len-1;
				prev *= 2;
			}
			else{
				it*=2;
				prev *=2;
			}
				
		}
		int l = prev/2;
		int u = it;
		int m = 0;
		while(u>=l){
			m = l + (u-l)/2;
			if(arr[m] == x)
				return m;
			if(arr[m] > x)
				u = m-1;
			else
				l = m+1;
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = {};
		int x = 5;
		int index = exponentialSearch(arr, x);
		System.out.println(index);
	}
}
