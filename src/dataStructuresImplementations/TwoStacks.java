package dataStructuresImplementations;

/**
 * Maintains two stacks using single array by maintaining 
 * 2 stacks on both extreme ends. this way it utilizes full
 * space available at any point.
 * [stack1 -->      <--stack2]
 * Runtime of all operations: O(1)
 * @author Utkarsh
 *
 */
public class TwoStacks {
	
	public static void main(String[] args){
		 TwoStacks ts = new TwoStacks(5); 
	        ts.push1(5); 
	        ts.push2(10); 
	        ts.push2(15); 
	        ts.push1(11); 
	        ts.push2(7); 
	        System.out.println("Popped element from" + 
	                           " stack1 is " + ts.pop1()); 
	        ts.push2(40); 
	        System.out.println("Popped element from" + 
	                         " stack2 is " + ts.pop2());
	        ts.push2(24);
	        ts.pop1();
	        ts.push2(53);
	        ts.push2(51);
	        
	}
	
	int[] stack;
	int size;
	int top1;
	int top2;
	public TwoStacks(int size){
		this.stack = new int[size];
		this.size = size;
		top1 = -1;
		top2 = size;
	}
	
	public boolean push1(int num){
		// check with the top2 for overflow
		if(top1+1 == top2){
			System.out.println("Stack1 overflow");
			return false;
		}
		this.stack[++top1] = num;
		return true;
	}
	
	public boolean push2(int num){
		// check with top1 for overflow
		if(top2-1 == top1){
			System.out.print("Stack2 overflow");
			return false;
		}
		this.stack[--top2] = num;
		return true;		
	}
	
	public int pop1(){
		// check -1 for underflow
		if(top1 == -1){
			System.out.println("Stack1 underflow");
			System.exit(1);
		}
		return stack[top1--];
	}
	
	public int pop2(){
		// check size for underflow
		if(top2 == size){
			System.out.println("Stack2 underflow");
			System.exit(1);
		}
		return stack[top2++];
	}
	
}
