package dataStructuresImplementations;

import java.util.Stack;

/**
 * InOrder is left root right
 * PreOrder is root left right
 * PostOrder is left right root
 * all 3 InOrder, PreOrder, PostOrder traversal take O(n)
 * @author Utkarsh
 */
public class BinaryTreeTraversal {
	
	/**
	 * Simple recursive solution
	 * Runtime: O(n)
	 * @param root
	 */
	static void printInOrder(Node root){
		if(root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.val+" ");
		printInOrder(root.right);
	}
	
	/**
	 * print inOrder using stack with single while loop for
	 * reaching all the nodes.
	 * Runtime: O(n)
	 * @param root
	 */
	static void printInOrderUsingStack(Node root) {
		if(root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		Node tmp = root.left;
		while(tmp!=null) {
			if(tmp.left!=null) {
				stack.push(tmp);
				tmp = tmp.left;
				continue;
			} else {
				System.out.print(tmp.val+" ");
			}
			
			if(!stack.isEmpty()) {
				Node cur = stack.pop();
				System.out.print(cur.val+" ");
				tmp = cur.right;
			}else // only reaches here after hitting all the elements
				tmp = null;
		}
	}
	
	/**
	 * prints inOrder using stack and inner while loop to
	 * get to the left most node
	 * Runtime: O(n) , even though it looks like double loop, it is just 
	 * going through left elements right away before processing further
	 */
	static void printInOrderUsingStackLoopy(Node root) {
		if(root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node cur = root;
		while(cur!=null || !stack.isEmpty()) {
			// keep pushing until left most node reached
			while(cur!=null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			System.out.print(cur+" ");
			cur = cur.right;
			
		}
	}
	
	static void printPreOrder(Node root){
		if(root == null)
			return;
		System.out.print(root.val+" ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	
	static void printPostOrder(Node root){
		if(root == null)
			return;
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.val+" ");
	}
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int num){
			this.val = num;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.val);
		}
	}
	
	static class BinaryTree{
		Node root;
		
		public BinaryTree(int num){
			this.root = new Node(num);
		}
	}
	
	public static void main(String[] args){
		
		// test set 1
		BinaryTree bt = new BinaryTree(5);
		bt.root.left = new Node(3);
		bt.root.right = new Node(7);
		bt.root.left.left = new Node(2);
		bt.root.left.right = new Node(4);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(8);
		System.out.println("SET 1");
		System.out.println("print InOrder using recursion: ");
		printInOrder(bt.root);
		System.out.println("\nPrint InOrder using stack (single loop): ");
		printInOrderUsingStack(bt.root);
		System.out.println("\nPrint InOrder using stack (double loop): ");
		printInOrderUsingStackLoopy(bt.root);
		
		System.out.println("\nprint PreOrder: ");
		printPreOrder(bt.root);
		System.out.println("\nprint PostOrder: ");
		printPostOrder(bt.root);

		// test set 2
		BinaryTree tree = new BinaryTree(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        System.out.println("\n\nSET 2");
		System.out.println("print InOrder using recursion: ");
		printInOrder(tree.root);
		System.out.println("\nPrint InOrder using stack (single loop): ");
		printInOrderUsingStack(tree.root);
		System.out.println("\nPrint InOrder using stack (double loop): ");
		printInOrderUsingStackLoopy(tree.root);
		
		System.out.println("\nprint PreOrder: ");
		printPreOrder(tree.root);
		System.out.println("\nprint PostOrder: ");
		printPostOrder(tree.root);
	}
}
