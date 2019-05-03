package dataStructuresImplementations;

/**
 * swap 2 nodes in a list without changing the data
 * Running Time: O(n)
 * @author Utkarsh
 *
 */
public class LinkedListSwapNodes {
	
	// tester
	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		ll.add(23);
		ll.add(43);
		ll.add(11);
		ll.add(9);
		ll.add(25);
		ll.print(); // before swap
		ll.swap(23, 25); // swap happens at this step
		ll.print(); // after swap
	}
	
	static class LinkedList{
		
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
		
		public void add(int num){
			Node newNode = new Node(num);
			Node temp = head;
			if(this.head == null)
				this.head = newNode;
			else{
				while(temp.next!=null){
					temp = temp.next;
				}
				temp.next = newNode;
			}
		}
		
		public void print(){
			Node temp = this.head;
			while(temp!=null){
				System.out.print(temp.val+" --> ");
				temp = temp.next;
			}
			System.out.println();
		}
		
		/**
		 * Main swap logic
		 * Runtime: O(n)
		 * @param a
		 * @param b
		 */
		public void swap(int a, int b){
			// use temp so head itself is not changed in the list
			Node temp = this.head;
			// we use before nodes to store nodes before nodes to be swapped
			Node beforeN1 = null;
			Node beforeN2 = null;
			Node n1 = null;
			Node n2 = null;
			while(temp!=null){
				if(temp.next!= null && temp.next.val == a)
					beforeN1 = temp;
				if(temp.val == a)
					n1 = temp;
				if(temp.next!= null && temp.next.val == b)
					beforeN2 = temp;
				if(temp.val == b)
					n2 = temp;
				temp = temp.next;
			}
			// if either node not found then no swap possible
			if(n1 == null || n2 == null ){
				System.out.println("Cannot swap something that is not present");
			}
			// if node before n1 is null means n1 is head
			if(beforeN1 == null)
				this.head = n2;
			else
				beforeN1.next = n2;
			// if node before n2 is null means n2 is head
			if(beforeN2 == null)
				this.head = n1;
			else
				beforeN2.next = n1;
			// change next links of n1 and n2
			Node temp2 = n1.next;
			n1.next = n2.next;
			n2.next = temp2;
			
		}
	}
}
