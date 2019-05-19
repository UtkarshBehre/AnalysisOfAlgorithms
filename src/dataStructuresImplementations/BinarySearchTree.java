package dataStructuresImplementations;

/**
 * Binary Search Tree Search and Insertion
 * Runtime: O(h), h is height of the bst which could be n in worst case of a skewed tree
 * n in worst case of skewed tree
 * @author Utkarsh
 *
 */
public class BinarySearchTree {
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.val);
		}
	}
	
	static class BST{
		private Node root;
		
		public boolean searchRec(int key) {
			return searchRec(root,key);
		}
		
		/**
		 * searches for a key recursively
		 * Runtime: O(h)
		 * @param node = current node
		 * @param key = element to search
		 * @return true if element is found
		 */
		public boolean searchRec(Node node, int key) {
			if(node==null)
				return false;
			if(key == node.val)
				return true;
			else if(key < node.val)
				return searchRec(node.left, key);
			return searchRec(node.right,key);
		}
		
		public void insertRec(int num) {
			root = insertRec(root, num);
		}
		
		/**
		 * inserts element into the bst as a leaf in right position
		 * Runtime: O(h)
		 * @param node = current node
		 * @param num = element to insert
		 * @return expect node after insertion
		 */
		public Node insertRec(Node node, int num) {
			if(node == null) {
				node = new Node(num);
				return node;
			}
			if(num == node.val) {
				System.out.println("No duplicate elements are allowed in a "
						+ "Binary Search Tree.");
				return root;
			}
			else if(num < node.val) {
				node.left = insertRec(node.left,num);
			}
			else 
				node.right = insertRec(node.right,num);
			return node;
		}
		
		/**
		 * used for internally calling recursive delete method
		 * @param num = key to be deleted from the tree
		 */
		public void deleteKey(int num) {
			
			root = deleteRec(root, num);
		}
		
		/**
		 * Replaces the value of key to be deleted in node with the min value
		 * found on right subtree and then deletes the replaced value from its
		 * original location
		 * Runtime: O(h)
		 * @param node = current node
		 * @param num = key to delete
		 * @return expected node after deletion
		 */
		public Node deleteRec(Node node, int num) {
			if(node == null)
				return node;
			if(num < node.val)
				node.left = deleteRec(node.left, num);
			else if(num > node.val)
				node.right = deleteRec(node.right, num);
			else { // node.val is equal to num
				//in case of only 1 child we just return that child to link
				if(node.right==null)
					return node.left;
				else if(node.left==null)
					return node.right;
				else{ // node has 2 children
					// update node's val to next min on right side to delete
					node.val = getMin(node.right);
					// now delete that next min
					node.right = deleteRec(node.right, node.val);
				}
			}
			return node;
		}
		
		/**
		 * gets min element of bst
		 * Runtime:O(n)
		 * @param node = root of bst to look at
		 */
		public int getMin(Node node) {
			int min = node.val;
			while(node!=null){
				min = node.val;
				node = node.left;
			}
			return min;
		}
		
		/**
		 * iterative searching
		 * Runtime: O(h)
		 * @param val
		 * @return
		 */
		public boolean search(int val) {
			Node node = root;
			if(node == null)
				return false;
			while(node!=null) {
				if(node.val == val)
					return true;
				else if(val < node.val)
					node = node.left;
				else
					node = node.right;
			}
			return false;
		}
		
		/**
		 * iterative approach to insert element in binary search tree
		 * O(h)
		 * @param num = element to insert
		 */
		public void insert(int num) {
			Node key = new Node(num);
			Node node = root;
			if(root == null)
				root = key;
			while(node!=null) {
				if(key.val == node.val) {
					System.out.println("Duplicate keys not allowed in a Binary "
							+ "Search Tree.");
					return;
				}
				else if(key.val < node.val) {
					if(node.left!=null)
						node = node.left;
					else {
						node.left = key;
						return;
					}
				}else {
					if(node.right!=null)
						node = node.right;
					else {
						node.right = key;
						return;
					}
				}
			}
		}
		
		public void printInOrder() {
			printInOrder(root);
			System.out.println();
		}
		
		/**
		 * inOrder traversal should give values in increasing order for bst
		 * Runtime: O(n)
		 */
		public void printInOrder(Node node) {
			if(node==null)
				return;
			printInOrder(node.left);
			System.out.print(node.val+" ");
			printInOrder(node.right);
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		/*
			      50           
	           /     \         
	          30      70       
	         /  \    /  \      
	       20   40  60   80     
       */
		bst.insertRec(50);
		bst.insertRec(30);
		bst.insertRec(20);
		bst.insertRec(40);
		bst.insertRec(70);
		bst.insertRec(60);
		bst.insertRec(80);
		System.out.println(bst.searchRec(8));
		bst.printInOrder();
		System.out.println("\nDelete 40"); 
        bst.deleteKey(40); 
        System.out.println("Inorder traversal of the modified tree"); 
        bst.printInOrder();
  
        System.out.println("\nDelete 30"); 
        bst.deleteKey(30); 
        System.out.println("Inorder traversal of the modified tree"); 
        bst.printInOrder();
  
        System.out.println("\nDelete 70"); 
        bst.deleteKey(70); 
        System.out.println("Inorder traversal of the modified tree"); 
        bst.printInOrder();
        
        System.out.println("\nDelete 50"); 
        bst.deleteKey(50); 
        System.out.println("Inorder traversal of the modified tree"); 
        bst.printInOrder();
	}
}
