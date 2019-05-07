package dataStructuresImplementations;

/**
 * Implement k stacks in a single array.
 * Create a data structure kStacks that represents k stacks. 
 * Implementation of kStacks should use only one array, i.e., 
 * k stacks should use the same array for storing elements. 
 * Following functions must be supported by kStacks.
 * push(int x, int sn) –> pushes x to stack number ‘sn’ where sn is from 0 to k-1
 * pop(int sn) –> pops an element from stack number ‘sn’ where sn is from 0 to k-1
 * Runtime: O(1) for each
 * @author ab70352
 *
 */
public class KStacks {
	
	int[] arr;	// the stack itself available to us
	int[] next; // array to hold either next element of stack or next empty space available
	int[] top; 	// array to hold top pointers of each stack
	int free; 	// holds the current free slot index
	
	/** constructor to initialize all members according to size and stack count given
	 * @param size = given array size
	 * @param k = given number of stacks to be made
	 */
	public KStacks(int size, int k){
		arr = new int[size]; 	
		next = new int[size];
		top = new int[k];
		for(int i = 0; i<size; i++){
			next[i] = i+1; // this would just hold next empty slot available in start
		}
		next[size-1] = -1; // last value would be -1 to represent overflow
		free = 0; 		   // free would be 0 at start as 0 is first empty space
		for(int i = 0; i<k; i++)
			top[i] = -1;   // all top pointers will be -1
	}
	
	/** since full is not denoted by whether top is hitting array end
	 * we will have free as -1 if we didn't have any more empty space 
	 */
	boolean isFull(){
		return free == -1;
	}
	
	/**
	 * pushes an item to the required stack
	 * Runtime: O(1) | print() is not counted as thats for understanding purpose 
	 * @param item
	 * @param stackNo
	 * @return
	 */
	boolean push(int item, int stackNo){
		System.out.print("Pushing "+ item + " onto stack "+ stackNo);
		if(isFull()){
			System.out.print(": failed.\n");
			return false;
		}
		System.out.print(": Success.\n");
		int i = free; 			// store current empty location
		free = next[i]; 		// set free to next empty location
		next[i] = top[stackNo]; // store the current top element's location in next
		top[stackNo] = i; 		// set the top to that current empty location we stored earlier
		arr[i] = item; 			// set the item to the current empty location we stored earlier
		print(); 				// this is just for current state Understanding purposes in log
		return true;
	}
	
	/**
	 * pops an element from required stack if not empty
	 * Runtime: O(1) | print() is not counted as thats for understanding purpose
	 * @param stackNo
	 * @return
	 */
	boolean pop(int stackNo){
		if(top[stackNo] == -1){
			System.out.println("No item to pop!");
			return false;
		}
		int i = top[stackNo]; 	// store current top location of stack for later use
		top[stackNo] = next[i]; // set the top to the next element of the stack as per next[]
		next[i] = free; 		// as next[] is no longer in use we set the current free location on this
		free = i;				// now previously top location is freed up so we set that in free
		System.out.println("Item Popped: "+ arr[i] +" from stack "+stackNo); // for log understanding
		print(); 				// this is just for current state Understanding purposes in log
		return true;
	}
	
	void print(){
		System.out.println("=========================");
		System.out.print("Stack: ");
		for(int x: arr)
			System.out.print(x + " ");
		System.out.print("\nTop: ");
		for(int x: top)
			System.out.print(x + " ");
		System.out.print("\nNext: ");
		for(int x: next)
			System.out.print(x + " ");
		System.out.print("\nfree: " + free+"\n");
		System.out.println("=========================");
	}
	
	// tester
	public static void main(String[] args){
		KStacks ks = new KStacks(6, 3);
		ks.push(1, 0);  // | 0th Stack  -> 1 	| 1st Stack -> 		 | 2nd Stack -> |
		ks.push(2, 0);  // | 0th Stack  -> 1 2 	| 1st Stack -> 		 | 2nd Stack -> |
		ks.push(11, 1);  // | 0th Stack  -> 1 2 | 1st Stack -> 11 	 | 2nd Stack -> |
		ks.push(12, 1);  // | 0th Stack  -> 1 2 | 1st Stack -> 11 12 | 2nd Stack -> |
		ks.push(21, 2);  // | 0th Stack  -> 1 2 | 1st Stack -> 11 12 | 2nd Stack -> 21 |
		ks.push(22, 2);  // | 0th Stack  -> 1 2 | 1st Stack -> 11 12 | 2nd Stack -> 21 22|
		//testing overflow
		ks.push(3, 0);  // | 0th Stack  -> 1 2 | 1st Stack -> 11 12  | 2nd Stack -> 21 22|
		ks.push(13, 1);  // | 0th Stack  -> 1 2 | 1st Stack -> 11 12 | 2nd Stack -> 21 22|
		ks.push(23, 2);  // | 0th Stack  -> 1 2 | 1st Stack -> 11 12 | 2nd Stack -> 21 22|
		
		ks.pop(0);  // | 0th Stack  -> 1 | 1st Stack -> 11 12 	| 2nd Stack -> 21 22 |
		ks.pop(1);  // | 0th Stack  -> 1 | 1st Stack -> 11 		| 2nd Stack -> 21 22 |
		ks.pop(2);  // | 0th Stack  -> 1 | 1st Stack -> 11 		| 2nd Stack -> 21  |
		
		ks.pop(1);  // | 0th Stack  -> 1 | 1st Stack -> 	| 2nd Stack -> 21 |
		//testing underflow
		ks.pop(1);  // | 0th Stack  -> 1 | 1st Stack -> 	| 2nd Stack -> 21 |
		
		ks.push(24, 2);  // | 0th Stack  -> 1 | 1st Stack -> 	| 2nd Stack -> 21 24|
		ks.push(25, 2);  // | 0th Stack  -> 1 | 1st Stack -> 	| 2nd Stack -> 21 24 25|
		ks.push(26, 2);  // | 0th Stack  -> 1 | 1st Stack -> 	| 2nd Stack -> 21 24 25 26 |
		ks.push(14, 1);  // | 0th Stack  -> 1 | 1st Stack -> 14 | 2nd Stack -> 21 24 25 26 |
		System.out.println("------- Final popping ------");
		// popping again
		ks.pop(0);  // | 0th Stack  -> | 1st Stack -> 14 | 2nd Stack -> 21 24 25 26 |
		ks.pop(2);  // | 0th Stack  -> | 1st Stack -> 14 | 2nd Stack -> 21 24 25 |
		ks.pop(1);  // | 0th Stack  -> | 1st Stack -> 	 | 2nd Stack -> 21 24 25 |
		ks.pop(2);  // | 0th Stack  -> | 1st Stack -> 	 | 2nd Stack -> 21 24 |
		ks.pop(0);  // | 0th Stack  -> | 1st Stack -> 	 | 2nd Stack -> 21 24 |
		ks.pop(2);  // | 0th Stack  -> | 1st Stack -> 	 | 2nd Stack -> 21  |
		ks.pop(2);  // | 0th Stack  -> | 1st Stack -> 	 | 2nd Stack -> |
	}
	

}
