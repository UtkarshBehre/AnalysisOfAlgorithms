package sortingAlgorithms.implementations;

/**
 * Implement merge sort for doubly linked list
 * Running Time: O(nlogn)
 * @author Utkarsh
 *
 */
public class MergeSortDoublyLinkedList {
	
	// tester
	public static void main(String[] args){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add(62);
		dll.add(52);
		dll.add(23);
		dll.add(42);
		dll.add(1);
		dll.add(0);
		dll.add(8);
		dll.print();
		dll.sort(); // sorting happens here
		dll.print();
	}
	
	static class DoublyLinkedList{
		Node head;
		
		class Node{
			int val;
			Node next;
			Node prev;
			
			public Node(int val){
				this.val = val;
				this.next = null;
				this.prev = null;
			}
			@Override
			public String toString() {
				return String.valueOf(this.val);
			}
		}
		
		/**
		 * makes a new node with num val and adds it
		 * @param num
		 */
		public void add(int num){
			Node newNode = new Node(num);
			this.addNode(newNode);
		}
		
		/**
		 * adds the new node
		 * @param newNode
		 */
		public void addNode(Node newNode){
			Node temp = this.head;
			newNode.prev = null;
			if(this.head == null){
				this.head = newNode;
			}
			else{
				while(temp.next!=null){
					temp = temp.next;
				}
				temp.next = newNode;
				newNode.prev = temp;
			}
		}
		
		/**
		 * prints the linked list in node formate | prev=x, val=y, next=z
		 */
		public void print(){
			Node temp = this.head;
			while(temp!=null){
				System.out.print("| prev="+temp.prev+", val="+temp.val+", next="+temp.next+" |");
				temp = temp.next;
			}
			System.out.println();
		}
		
		/**
		 * sort method without the first node parameter
		 */
		public void sort(){
			// we pass this doubly linked list's head to merge sort it
			this.head = mergeSort(this.head);
		}
		
		/**
		 * Main Logic for merge sort implementation on doubly linked lists
		 * typical merge sort logic - divide in half and sort both halves
		 * Running Time: O(nlogn)
		 * @param head = first node of the given linked list to be sorted
		 */
		public Node mergeSort(Node head){
			if(head == null || head.next == null)
				return head;
			// divide the list in 2 parts
			Node rightLow = split(head);
			
			Node leftPart = mergeSort(head);
			Node rightPart = mergeSort(rightLow);

			// call the merge sorted lists method to merge both the divided parts in sorted way
			return mergeSortedLists(leftPart, rightPart);
		}
		
		/**
		 * logic is to run 1st pointer in 1x speed starting from first node 
		 * and 2nd pointer in 2x speed starting from 2nd node until 2nd pointer hits the end
		 * then return the 1x pointer's position
		 * @param head = first node of a doubly linked list
		 * @return middle node of the given doubly linked list
		 */
		public Node split(Node head){
			if(head == null || head.next == null)
				return head;
			else{
				Node normalSpeed = head;
				Node doubleSpeed = head.next;
				while(doubleSpeed.next!=null && doubleSpeed.next.next !=null){
					doubleSpeed = doubleSpeed.next.next;
					normalSpeed = normalSpeed.next;
				}
				Node temp = normalSpeed.next;
				normalSpeed.next = null;
				return temp;
			}
		}
		
		/**
		 * logic is to add both lists to a new list node by node by picking
		 * the smaller element amongst the 2 lists found and traverse only 
		 * that one until one of them hits the end
		 * at the end just add the remaining elements of the other list
		 * @param list1Itr = first node of the first doubly linked list
		 * @param list2Itr = first node of the second doubly linked list
		 * @return first node of the merged new doubly linked list
		 */
		public static Node mergeSortedLists(Node list1Itr, Node list2Itr){
			DoublyLinkedList sortedList = new DoublyLinkedList();
			// add the smaller element to the new list and traverse that list
			while(list1Itr!=null && list2Itr!=null){
				if(list1Itr.val == list2Itr.val){
					sortedList.add(list1Itr.val);
					sortedList.add(list1Itr.val);
					list1Itr = list1Itr.next;
					list2Itr = list2Itr.next;
				}
				else if(list1Itr.val < list2Itr.val){
					sortedList.add(list1Itr.val);
					list1Itr = list1Itr.next;
				}
				else{
					sortedList.add(list2Itr.val);
					list2Itr = list2Itr.next;
				}
			}
			
			// add the remaining elements of the left out list
			if(list1Itr!=null){
				sortedList.addNode(list1Itr);
			}
			if(list2Itr!=null){
				sortedList.addNode(list2Itr);
			}
			
			return sortedList.head;
		}
	}
}
