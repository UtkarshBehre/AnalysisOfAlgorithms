# AnalysisOfAlgorithms
This repository includes implementations of the following algorithms in Java.

## Searching Algorithms
***
| Searching Algorithms  | Time Complexity | How it works |
| :------------:		| :--------------:| :-----------|
| Linear Search 		|    O(n)         | search from first to last element 1 by 1 |
| Binary Search 		|    O(logn)      | divide the array in half, search which part(if not mid) element is in, repeat |
| Jump Search   		|    O(&#8730;n)  | jump from 0<sub>th</sub> index to &#8730;n step and so on until element found, then perform linear search in elements between last jump point to current |
| Interpolation Search 	|O(n)| O (loglogn)| just like binary search except mid point is pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ] |
| Exponential Search	| O(logn)    	  | jump step starts from 1 and doubles every turn until element found, then perform binary search in elements between last jump point and current |
| Ternary Search		| O(log<sub>c</sub>n)| just like binary search except the array is divided in more than 2 parts |
***

## Sorting Algorithms
***
|Sorting Algorithms		| Time Complexity | How it works |
|:---------------------:| :--------------:| :----------- |
|	Selection sort		| O(n<sup>2</sup> | loop from 0 to last making sure element is minimum|
|	Bubble Sort			| O(n<sup>2</sup> | loop from last to 0 making sure element is maximum|
|	Insertion sort		| O(n<sup>2</sup> | loop from 0 to last making sure elements upto current are sorted|
|	Merge Sort			| O(nlogn)		  | keep dividing by half until 1 element then start merging the sorted arrays until all subarrays are merged|
|	Heap Sort			| O(nlogn)		  | heapify the given array then loop from last to first swapping first (biggest) element with current and heapify the array leaving the swapped elements
|	Quick Sort			| O(n<sup>2</sup> | sort by pick a pivot index, then put the element in correct position, then sorting left and right sub arrays from pivot|