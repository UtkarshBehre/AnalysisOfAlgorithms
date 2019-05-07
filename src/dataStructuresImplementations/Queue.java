package dataStructuresImplementations;

public class Queue {
	int[] arr;
	int capacity, size, front, rear;
	
	public Queue(int capacity){
		this.arr = new int[capacity];
		this.size = 0;
		this.capacity = capacity;
		front = 0;
		rear = capacity-1;
	}
	
	/**
	 * adds another item to the queue at the end
	 * Runtime: O(1)
	 * @param item
	 * @return
	 */
	public boolean enQueue(int item){
		if(isFull()){
			System.out.println("Overflow condition occurred while trying to add "+ item);
			return false;
		}
		rear = (rear+1)%capacity;
		arr[rear] = item;
		size++;
		print();
		return true;
	}
	
	/**
	 * removes and returns the first item 
	 * Runtime: O(1)
	 * @return
	 */
	public int deQueue(){
		if(isEmpty()){
			System.out.println("Underflow condition occurred while trying to dequeue.");
			System.exit(1);
		}
		int item = arr[front];
		front = (front+1)%capacity;
		size--;
		print();
		return item;
	}
	
	public boolean isFull(){
		return size == capacity;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int front(){
		return size==0?Integer.MIN_VALUE:arr[front];
	}
	
	public int rear(){
		return size==0?Integer.MIN_VALUE:arr[rear];
	}
	
	void print(){
		for(int x: arr)
			System.out.print(x+" ");
		System.out.println();
	}
	
	public static void main(String[] args){
		Queue q = new Queue(5);
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.deQueue();
		q.deQueue();
		q.enQueue(5);
		q.enQueue(6);
		q.deQueue();
		q.enQueue(7);
		q.enQueue(8);
		System.out.println("Front: "+ q.front());
		System.out.println("Rear: "+ q.rear());
		q.enQueue(13);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		System.out.println("Front: "+ q.front());
		System.out.println("Rear: "+ q.rear());
		q.deQueue();
		System.out.println("Front: "+ q.front());
		System.out.println("Rear: "+ q.rear());
		q.deQueue();
	}
}
