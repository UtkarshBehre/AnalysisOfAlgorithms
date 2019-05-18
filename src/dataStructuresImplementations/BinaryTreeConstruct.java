package dataStructuresImplementations;

import java.util.HashMap;

/**
 * Construct Tree from given Inorder and Preorder traversals
 * @author Utkarsh
 *
 */
public class BinaryTreeConstruct {
	
	static class Node{
		char key;
		Node left;
		Node right;
		
		public Node(char c) {
			key = c;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.key);
		}
	}
	
	static class BinaryTree{
		Node root;
		static int preInd; //used as preOrder index iterator
		
		/**
		 * constructs the binary tree based on given inOrder and PreOrder Traversal
		 * Runtime: O(n)
		 * @param in = given inOrder traversal
		 * @param pre = given preOrder traversal
		 */
		public void constructTreeRecursive(String in, String pre) {
			HashMap<Character, Integer> inMap = convertToMap(in);
			root = buildTree(in, pre, 0, in.length()-1, inMap);
		}
		
		/**
		 * cuts the inOrder in left half and right half based on next character from
		 * preOrder then set left to that and right to that from those parts. 
		 * Runtime: O(n)
		 * @param in = given inOrder traversal
		 * @param pre = given preOrder traversal
		 * @param start = left index to look for in inOrder map
		 * @param end = right index upto which to look for inOrder map
		 * @param inMap = hashmap with inOrder characters with index to make search O(1)
		 * @return the next node to be added to the tree from preOrder
		 */
		public Node buildTree(String in, String pre, int start, int end, HashMap<Character, Integer> inMap) {
			
			if(start>end)
				return null;
			
			Node node = new Node(pre.charAt(preInd++));
			
			if(start == end)
				return node;
			
			int inPosition = inMap.get(node.key);
			
			node.left = buildTree(in, pre, start, inPosition -1, inMap);
			node.right = buildTree(in, pre, inPosition+1, end, inMap);
			
			return node;
		}
		
		private HashMap<Character, Integer> convertToMap(String in){
			HashMap<Character,Integer> inMap = new HashMap<Character, Integer>();
			for(int i = 0; i<in.length(); i++) {
				inMap.put(in.charAt(i), i);
			}
			return inMap;
		}
		
		public void printTree() {
			System.out.println("InOrder Traversal");
			printInOrder(root);
			System.out.println("\nPreOrder Traversal");
			printPreOrder(root);
		}
		
		static void printInOrder(Node root){
			if(root == null)
				return;
			printInOrder(root.left);
			System.out.print(root.key+" ");
			printInOrder(root.right);
		}
		
		static void printPreOrder(Node root){
			if(root == null)
				return;
			System.out.print(root.key+" ");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}
	
	
	
	public static void main(String[] args) {
		//set 1
//		String inOrder = "DBEAFC";
//		String preOrder = "ABDECF";
		//set 2
		String inOrder = "DEBACGF";
		String preOrder = "ABDECFG";
		BinaryTree bt = new BinaryTree();
		//bt.constructUsingInPreOrder(inOrder, preOrder);
		bt.constructTreeRecursive(inOrder, preOrder);
		bt.printTree();
	}
}
