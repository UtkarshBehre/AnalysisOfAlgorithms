package dataStructuresImplementations;

/**
 * Implementation of a circular linked list
 * add at end, add at start, add after node
 * @author Utkarsh
 */
public class CircularLinkedList {
	
	// tester
	public static void main(String[] args){
		CircularLinkedList cll = new CircularLinkedList();
		cll.addAtLast(10);
		cll.addAtFirst(20);
		cll.addAtLast(30);
		cll.addAtFirst(40);
		int oldVal = 20; // value after which new node to be inserted
		cll.addAfter(25, oldVal); 
		cll.print();
	}
	
	Node head;

	class Node{
		int val;
		Node next;
		public Node(int val){
			this.val = val;
			this.next = null;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return this.val == ((Node)obj).val;
		}
	}

	/**
	 * add new node at the end
	 * @param num
	 */
	public void addAtLast(int num){
		Node newNode = new Node(num);
		
		Node temp = head;
		if(this.head == null){
			this.head = newNode;
		}
		else{
			while(temp.next!=this.head){
				temp = temp.next;
			}
			temp.next = newNode;
		}
		newNode.next = this.head;
	}
	
	/**
	 * adds new node with num at start
	 * @param num
	 */
	public void addAtFirst(int num){
		Node newNode = new Node(num);
		Node temp = head;
		if(this.head == null){
			this.head = newNode;
		}
		else{
			while(temp.next!= this.head){
				temp = temp.next;
			}
			temp.next = newNode;
		}
		newNode.next = this.head;
		this.head = newNode;
	}
	
	/**
	 * adds new node with num after old node
	 * if old is not found then adds the new node at end
	 * @param num
	 * @param old
	 */
	public void addAfter(int num, int old){
		Node newNode = new Node(num);
		Node temp = this.head;
		while(temp.val!=old && temp.next!=this.head)
			temp = temp.next;
		
		Node next = temp.next;
		temp.next = newNode;
		newNode.next = next;
	}
	
	public void print(){
		Node temp = this.head;
		do{
			System.out.print(temp.val+" ");
			temp = temp.next;
		}while(temp!=this.head);
	}
}