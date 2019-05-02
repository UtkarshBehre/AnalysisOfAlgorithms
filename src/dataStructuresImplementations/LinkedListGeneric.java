package dataStructuresImplementations;

public class LinkedListGeneric<E> {
	public ListNode<E> first;
	
	public LinkedListGeneric() {
		first = null;
	}
	
	public void add(E e) {
		ListNode<E> newNode = new ListNode<E>(e,null);
		if(first == null)
			first = newNode;
		else {
			ListNode<E> node = first;
			while(node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
	}
	
	public void addFirst(E e) {
		ListNode<E> newNode = new ListNode<E>(e,null);
		if(first!=null) {
			newNode.next = first;
			first = newNode;
		}
	}
	public void removeLast() {
		
		if(first!=null) {
			ListNode<E> node = first;
			if(first.next==null)
				first = null;
			else {
				while(node.next.next!=null) {
					node = node.next;
				}
				node.next = null;	
			}
			
		}
		
	}
	
	public void removeFirst() {
		if(first!=null) {
			if(first.next == null) {
				first = null;
			} else {
				first = first.next;
			}
			
		}
	}
	
	public boolean contains(E e) {
		if(first==null)
			return false;
		else {
			ListNode<E> node = first;
			while(node!=null) {
				if(node.e.equals(e))
					return true;
				node = node.next;
			}
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedListGeneric<Integer> list = new LinkedListGeneric<Integer>();
		list.add(24);
		list.add(56);
		list.removeLast();
		list.add(98);
		list.removeFirst();
		list.addFirst(76);
		System.out.println("Search: " +list.contains(98));
	}
	
}

class ListNode<E>{
	public E e;
	public ListNode<E> next;
	
	public ListNode(E e, ListNode<E> node) {
		this.e = e;
		this.next = node;
	}
}
