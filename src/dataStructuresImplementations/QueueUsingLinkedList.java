package dataStructuresImplementations;

public class QueueUsingLinkedList {
	
	static class Node{
		int val;
		Node next;
		
		public Node(int item){
			this.val = item;
			this.next = null;
		}
		
		@Override
		public String toString(){
			return String.valueOf(this.val);
		}
	}
	
	static class Queue{
		Node front, rear;
		
		public Queue(){
			front = null;
			rear = null;
		}
		
		public boolean enqueue(int item){
			Node newNode = new Node(item);
			if(rear == null){
				front = rear = newNode;
			} else{
				rear.next = newNode;
				rear = rear.next;
			}
			return true;
		}
		
		public Node dequeue(){
			Node temp;
			if(isEmpty()){
				System.out.println("No item to remove.");
				temp = null;
			}else if( front == rear){
				temp = front;
				front = rear = null;
			}else{
				temp = front;
				front = front.next;
			}
			return temp;
		}
		
		boolean isEmpty(){
			return front == null;
		}
	}
	public static void main(String[] args){
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		System.out.println(q.dequeue());
		q.enqueue(40);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(50);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(60);
		System.out.println(q.dequeue());
		q.enqueue(70);
		q.enqueue(80);
		q.enqueue(90);
		q.enqueue(100);
		q.dequeue();
		q.dequeue();
		System.out.println(q.dequeue());
		q.dequeue();
		q.dequeue();
	}
}
