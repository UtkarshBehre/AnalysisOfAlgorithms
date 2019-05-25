package dataStructuresImplementations;

/**
 * Implement following methods for a min-heap
 * getMini() - O(1)
 * extractMin(), decreaseKey(), insert(), delete() - O(logn) 
 * @author Utkarsh
 *
 */
public class MinHeap {
	int[] minHeap = new int[100];
	int size;
	
	public MinHeap() {
		this.size = 0;
	}
	
	/**
	 * returns first element as thats minimum for min-heap
	 * Runtime: O(1)
	 */
	public int getMini() {
		return minHeap[0];
	}
	
	/**
	 * takes out the first element as min element, assigns last element
	 * to it and call heapify to fix the heap
	 * Runtime: O(logn)
	 */
	public int extractMin() {
		int min = minHeap[0];
		minHeap[0] = minHeap[size-- -1];
		heapify(0);
		return min;
	}
	
	/**
	 * decreases value at i and makes it newVal, assuming newVal is lower,
	 * then puts the newVal in its right position by check with parent
	 * Runtime: O(logn)
	 */
	public void decreaseKey(int i, int newVal) {
		minHeap[i] = newVal;
		int parent = (i-1)/2;
		while(minHeap[parent] > newVal) {
			swap(parent, i);
			i = parent;
			parent = (i-1)/2;
		}
	}
	
	/**
	 * inserts a new value to the min heap
	 * inserts at after the last element and starts pushing it upwards to
	 * its correct position by swapping with parent until parent is greater
	 * Runtime: O(logn)
	 */
	public void insert(int val) {
		minHeap[size++] = val;
		int i = size-1;
		int parent = (i-1)/2;
		while(parent>=0 && minHeap[parent] > minHeap[i]) {
			swap(parent,i);
			i = parent;
			parent = (i-1)/2;
		}
	}
	
	/**
	 * deletes a value at index i by decreasing value to min and extracting it
	 * Runtime: O(logn)
	 */
	public void delete(int i) {
		decreaseKey(i,Integer.MIN_VALUE);
		extractMin();
	}
	
	/**
	 * starts heapify process on element i cascading it to its proper place
	 * by swapping with children as they are encountered
	 * Runtime: O(logn)
	 */
	private void heapify(int i) {
		int left = 2*i+1;
		int right = 2*i+2;
		int smallest = i;
		if(left<size && minHeap[smallest] > minHeap[left])
			smallest = left;
		if(right<size && minHeap[smallest] > minHeap[right])
			smallest = right;
		if(smallest!=i) {
			swap(smallest, i);
			heapify(smallest);
		}
	}
	
	/**
	 * utility: print the minHeap
	 */
	public void print() {
		System.out.println();
		for(int i = 0; i<size; i++) {
			System.out.print(minHeap[i]+ " ");
		}
	}
	
	/**
	 * utility: swaps values on indexes i1 and i2 in the minHeap
	 */
	private void swap(int i1, int i2) {
		int tmp = minHeap[i1];
		minHeap[i1] = minHeap[i2];
		minHeap[i2] = tmp;
	}
	
	// tester code
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(10);
		minHeap.insert(30);
		minHeap.insert(15);
		minHeap.insert(50);
		minHeap.delete(4);
		minHeap.insert(100);
		minHeap.insert(40);
		minHeap.insert(35);
		minHeap.insert(27);
		minHeap.insert(36);
		minHeap.insert(38);
		minHeap.print();
		minHeap.decreaseKey(4,25);
		minHeap.print();
		minHeap.decreaseKey(8,24);
		minHeap.print();
		System.out.print("\nMin is: "+minHeap.getMini());
		minHeap.print();
		System.out.print("\nExtracted Min is: "+minHeap.extractMin());
		minHeap.print();
	}
}
