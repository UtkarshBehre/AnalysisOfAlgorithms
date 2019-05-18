package dataStructuresImplementations;

import java.util.LinkedList;

/**
 * print the tree nodes: Level Order Tree Traversal or Breadth first traversal
 * Runtime: O(n)
 * @author Utkarsh
 *
 */
public class BinaryTreeLevelOrder {

	static class Node{
		int val;
		Node left;
		Node right;

		public Node(int num){
			this.val = num;
		}
	}

	static class BinaryTree{
		Node root;

		public BinaryTree(int num){
			this.root = new Node(num);
		}
		
		/**
		 * simplest and best solution using queue
		 * Runtime: O(n)
		 */
		public void printLevelOrderUsingQueue(){
			java.util.Queue<Node> queue = new LinkedList<Node>();
			if(root!=null)
				queue.add(root);
			while(!queue.isEmpty()){
				Node tmp = queue.poll();
				if(tmp.left!=null)
					queue.add(tmp.left);
				if(tmp.right!=null)
					queue.add(tmp.right);
				System.out.print(tmp.val+" ");
			}
		}
		
		/**
		 * solution without using extra space other than call stack
		 * Runtime: O(n^2)
		 * Space: O(1) if call stack not counted otherwise O(n)
		 */
		public void printLevelOrderNoSpace(){
			int h = getHeight(root);
			for(int i=1;i<=h;i++){
				printCurrentLevel(root, i);
			}
		}
		
		private void printCurrentLevel(Node node, int level){
			if(node==null)
				return;
			if(level ==1){
				System.out.print(node.val+" ");
			}
			else if(level > 1){
				printCurrentLevel(node.left, level-1);
				printCurrentLevel(node.right, level-1);
			}
		}
		
		private int getHeight(Node node){
			int h = 0;
			if(node==null)
				return 0;
			int h1 = getHeight(node.left);
			int h2 = getHeight(node.right);
			h = h1>h2?h1:h2;
			return h+1;
		}

		
		
		/**
		 * solution using array as changing parameter
		 * not a good solution as array size keeps changing
		 * Runtime: O(n)
		 * Aux space: O(n)
		 * @param root
		 */
		public void printLevelOrderUsingArray(Node root){
			Node[] nodes ={root};
			printLevelOrder(nodes);
		}
		private void printLevelOrder(Node[] nodes){
			if(isLastLevel(nodes))
				return;
			Node[] newNodesArr = new Node[nodes.length*2];
			int i = 0;
			for(Node node : nodes){
				if(node!=null){
					System.out.print(node.val+" ");
					newNodesArr[i++] = node.left;
					newNodesArr[i++] = node.right;
				}
			}
			printLevelOrder(newNodesArr);
		}

		private static boolean isLastLevel(Node[] nodes){
			boolean res = true;
			for(Node node : nodes){
				if(node!= null){
					res = false;
					break;
				}
			}
			return res;
		}

	}
	// testing ground
	public static void main(String[] args){

		// test set 1
		BinaryTree bt = new BinaryTree(5);
		bt.root.left = new Node(3);
		bt.root.right = new Node(7);
		bt.root.left.left = new Node(2);
		bt.root.left.right = new Node(4);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(8);
		bt.root.right.right.right = new Node(9);
		System.out.println("SET 1");
		System.out.print("\nprint levelorder using printLevelOrderUsingArray: ");
		bt.printLevelOrderUsingArray(bt.root);
		System.out.print("\nprint levelorder using printLevelOrderNoSpace: ");
		bt.printLevelOrderNoSpace();
		System.out.print("\nprint levelOrder using queue: ");
		bt.printLevelOrderUsingQueue();
		
		// test set 2
		BinaryTree tree = new BinaryTree(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		System.out.println("\n\nSET 2");

		System.out.print("\nprint levelorder using printLevelOrderUsingArray: ");
		tree.printLevelOrderUsingArray(tree.root);
		System.out.print("\nprint levelorder using printLevelOrderNoSpace: ");
		tree.printLevelOrderNoSpace();
		System.out.print("\nprint levelOrder using queue: ");
		tree.printLevelOrderUsingQueue();
	}
}
