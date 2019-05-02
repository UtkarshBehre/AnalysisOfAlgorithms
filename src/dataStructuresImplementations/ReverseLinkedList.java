package dataStructuresImplementations;

/**
 * Reverse the linked list using iterative, recursive and grouping approaches
 * Runtime: O(n)
 * @author Utkarsh
 */
public class ReverseLinkedList {
	
	// tester
	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		ll.add(23);
		ll.add(43);
		ll.add(11);
		ll.add(9);
		ll.add(25); 
        ll.add(8); 
        ll.add(7); 
        ll.add(6); 
        ll.add(5); 
        ll.add(4); 
        ll.add(3); 
        ll.add(2); 
        ll.add(1); 
		ll.print(); 
		ll.reverse();
		System.out.println("reversing using iterative approach");
		ll.print();
		ll.reverse(null, ll.head);
		System.out.println("reversing using recursive approach");
		ll.print();
		int k = 3; // change the key to increase grouping size
		ll.reverseInGroupsOfK(k);
		System.out.println("reversing in groups of "+k );
		ll.print();
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

		/**
		 * reverses the list using iterative approach
		 * Running Time: O(n)
		 */
		public void reverse(){
			Node itr = this.head;
			Node next = null;
			Node prev = null;
			while(itr!= null){
				next = itr.next;
				itr.next = prev;
				prev = itr;
				itr = next;
			}
			this.head = prev;
		}
		
		/**
		 * reverses the list using recursive approach
		 * Running Time: O(n)
		 * @param prev = keep track of last node
		 * @param cur = keep track of current node
		 * @return
		 */
		public Node reverse(Node prev, Node cur){
			if(cur.next == null){
				cur.next = prev;
				this.head = cur;
				return head;
			}
			Node next = cur.next;
			cur.next = prev;
			prev = cur;
			reverse(prev, next);
			return head;
		}
		
		public void reverseInGroupsOfK(int k){
			this.head = reverseInGroupsOfK(this.head, k);
		}
		
		/**
		 * reverse every k nodes in list and link them
		 * Runtime: O(n)
		 * @param head = head of the sublist that needs to be revered
		 * @param k = nodes in group to be reversed
		 * @return
		 */
		public Node reverseInGroupsOfK(Node head, int k){
			Node itr = head;
			Node next = null;
			Node prev = null;
			int i = 1;
			// normal reverse logic until k nodes
			while(itr!=null && i <= k){
				next = itr.next;
				itr.next = prev;
				prev = itr;
				itr = next;
				i++;
			}
			
			if(next!=null){
				// we attach the current sublist's last node with the next reversed list
				head.next = reverseInGroupsOfK(itr,k);
			}
			// this will be the first prev i.e. the head of the first reversed sub list
			return prev;
		}
		
		
		public void print(){
			Node temp = this.head;
			while(temp!=null){
				System.out.print(temp.val+" --> ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
}
