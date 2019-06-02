package dataStructuresImplementations;

import java.util.Stack;
/**
 * Special stack that can provide min element of the stack at any
 * point in O(1) runtime
 * @author Utkarsh
 *
 */
@SuppressWarnings("serial")
public class SpecialStack extends Stack<Integer>{
	Stack<Integer> min = new Stack<Integer>();
	
	/*
	 * push 
	 * Push and pop less space efficient way by pushing and 
	 * popping the top elements from both min and main stacks
	 */
	
	public void pushms(Integer item) {
		if(!min.isEmpty() && min.peek() <= item)
			min.push(min.peek());
		else
			min.push(item);
		super.push(item);
	}
	
	public void popms() {
		min.pop();
		super.pop();
	}
	
	/*
	 * push and pop space optimized way
	 * by only pushing and popping next least or equal element 
	 * to min stack while pushing and popping all on main stack
	 */
	
	public Integer pushls(Integer item){
		if(min.isEmpty())
			min.push(item);
		else if(!min.isEmpty() && min.peek() >= item)
			min.push(item);
		return this.push(item);
	}
	
	public void popls(){
		if(min.peek() == this.pop())
			min.pop();
	}
	
	/**
	 * as we keep maintaining the min element of stack in min
	 * stack this operation takes constant time
	 * runtime: O(1)
	 * @return minimum element of the stack
	 */
	public Integer getMin(){
		return min.peek();
	}
	
	public static void main(String[] args){
		SpecialStack s = new SpecialStack(); 
        s.pushls(10);
        s.pushls(20);
        s.pushls(25);
        s.pushls(10);
        s.pushls(30); 
        System.out.println(s.getMin()); 
        s.pushls(5); 
        System.out.println(s.getMin());
        s.popls();
        System.out.println(s.getMin());
	}
}
