package dataStructuresImplementations;

public class StackOperations {
	public static void main(String[] args){
		Stack s = new Stack(5);
		s.push(24);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(20);
		s.push(30);
		s.push(40);
		s.pop();
		s.push(50);
		s.push(60);
		s.push(70);

		s.push(53);
	}
	
	static class Stack{
		int[] array;
		int top;
		int maxSize;
		public Stack(int size){
			array = new int[size];
			maxSize = size;
			top = -1;
		}
		
		public boolean push(int num){
			if(this.top +1 == this.maxSize){
				System.out.println("Stack overflow: element cannot be pushed");
				return false;
			} else{
				this.top++;
				this.array[this.top] = num;
				return true;
			}
		}
		
		public int pop(){
			if(top == -1){
				System.out.println("Stack underflow: no elements to pop");
				return 0;
			} else{
				return this.array[this.top--];
			}
		}
		public int peek(){
			if(top == -1){
				System.out.println("Stack underflow: no elements to pop");
				return 0;
			} else{
				return this.array[this.top];
			}
		}
		public boolean isEmpty(){
			if(top==-1)
				return true;
			else
				return false;
		}
	}
}
