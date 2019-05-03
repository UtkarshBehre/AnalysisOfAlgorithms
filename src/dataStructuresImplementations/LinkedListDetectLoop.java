package dataStructuresImplementations;

import java.util.*;

public class LinkedListDetectLoop {
	public static void main(String[] args){
		LinkedListGeneric<Integer> ll = new LinkedListGeneric<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.first.next.next.next.next=ll.first.next;
		detectAndRemoveLoop(ll.first);
//		if(detectAndRemoveLoop2(ll.first))
//			System.out.println("Loop was found and removed.");
//		else
//			System.out.println("No loop found");
		
		ll.print();
	}
	
	/**
	 * detect and remove loop using arraylist 
	 * Runtime: O(n^2)
	 * @param head
	 * @return
	 */
	static ListNode<Integer> detectAndRemoveLoop(ListNode<Integer> head){
		ListNode<Integer> cur = head;
		ArrayList<Integer> al = new ArrayList<>();
		while(cur!=null){
			if(al.contains(cur.next.e))
				cur.next = null;
			al.add(cur.e);
			cur = cur.next;
		}
		return head;
	}
	
	/**
	 * detect and remove loop using HashSet
	 * Runtime: O(n)
	 * @param head
	 * @return
	 */
	static ListNode<Integer> detectAndRemoveLoop2(ListNode<Integer> head){
		ListNode<Integer> cur = head;
		HashSet<Integer> hs = new HashSet<>();
		while(cur!=null){
			if(hs.contains(cur.next.e))
				cur.next = null;
			hs.add(cur.e);
			cur = cur.next;
		}
		return head;
	}
	
	/**
	 * detect remove loop using same linked list only
	 * @param node = head of the linked list
	 * @return returns 1 if true and 0 if false
	 */
    static boolean detectAndRemoveLoop3(ListNode<Integer> node) { 
        ListNode<Integer> slow = node, fast = node; 
        while (slow != null && fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
  
            // If slow and fast meet at same point then loop is present
            // keep in mind this can be any node in the loop and 
            // not necessarily first or last node of the node
            if (slow == fast) { 
                removeLoop(slow, node); 
                return true; 
            } 
        } 
        return false; 
    } 
  
    /**
     * remove loop if the loop was found
     * @param loop = node that was matched before calling this method
     * @param head = head of the node
     */
    static void removeLoop(ListNode<Integer> loop, ListNode<Integer> head) {
    	// need 2 of same to find count of nodes in the loop
        ListNode<Integer> ptr1 = loop; 
        ListNode<Integer> ptr2 = loop; 
  
        // Count the number of nodes in loop 
        int k = 1, i; 
        while (ptr1.next != ptr2) { 
            ptr1 = ptr1.next; 
            k++; 
        } 
  
        // reset 1 pointer to head so that this can reach the head of loop 
        ptr1 = head; 
  
        // And the other pointer to head to set k nodes after head 
        ptr2 = head; 
        for (i = 0; i < k; i++) { 
            ptr2 = ptr2.next; 
        } 
  
        /*  Move both pointers at the same pace, ptr2 is already k nodes ahead, 
         so it would loop back and they will meet at loop starting node */
        while (ptr2 != ptr1) { 
            ptr1 = ptr1.next; 
            ptr2 = ptr2.next; 
        } 
  
        // Get pointer to the last node 
        ptr2 = ptr2.next; 
        // ptr2 traversing will reach the last last node checked against loop head ptr1
        while (ptr2.next != ptr1) { 
            ptr2 = ptr2.next; 
        } 
  
        // loop's last node's next to null 
        ptr2.next = null; 
    } 
	
}
