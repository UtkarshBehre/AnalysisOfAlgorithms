package sortingAlgorithms.implementations;

public class InsertionSortLinkedList {
	
	// tester
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.add(24);
		sll.add(15);
		sll.add(2);
		sll.add(68);
		sll.add(57);
		sll.add(1);
		sll.print();
		sll.sortUsingInsertionSort();
		sll.print();
	}
	
	/**
	 * inner class singly linked list implementation
	 * @author Utkarsh
	 */
	static class SinglyLinkedList{
		Node head;
		
		class Node{
			int val;
			Node next;
			public Node(int val) {
				this.val = val;
				this.next = null;
			}
		}

		/**
		 * prints this linked list
		 */
		public void print() {
			Node itr = this.head;
			while(itr!=null) {
				System.out.print(itr.val +" ");
				itr = itr.next;
			}
			System.out.println();
		}
		
		/**
		 * adds a node with given val at the end
		 */
		public void add(int val) {
			Node n = new Node(val);
			Node itr = this.head;
			if(this.head == null)
				this.head = n;
			else {
				while(itr.next!=null) {
					itr = itr.next;
				}
				itr.next = n;
			}
		}
		
		/**
		 * adds a node at the node
		 */
		public void addNode(Node node) {
			Node itr = this.head;
			if(this.head == null)
				this.head = node;
			else {
				while(itr.next!=null) {
					itr = itr.next;
				}
				itr.next = node;
			}
		}
		
		/**
		 * inserts given new node in the list at a position where
		 * list stays sorted after insertion
		 * @param newNode = new node to be inserted in sorted position
		 */
		public void addNodeAtCorrectPosition(Node newNode) {
			Node itr = this.head;
			newNode.next = null;
			if(this.head == null || this.head.val > newNode.val) {
				newNode.next = this.head;
				this.head = newNode;
			}
			else {
				// iterate through until we hit a node whose next is bigger
				while(itr.next!=null && itr.next.val < newNode.val) 
					itr = itr.next;
				// relink the list so that new node is inserted in between current and next node
				newNode.next = itr.next;
				itr.next = newNode;
			}
		}
		
		/**
		 * adds the list elements in a new list in sorted way
		 * and points the head of this list to this new list's head
		 */
		public void sortUsingInsertionSort() {
			Node itr = this.head;
			SinglyLinkedList sll = new SinglyLinkedList();
			while(itr!=null) {
				Node temp = itr.next;
				sll.addNodeAtCorrectPosition(itr);
				itr = temp;
			}
			this.head = sll.head;
		}
	}
}
