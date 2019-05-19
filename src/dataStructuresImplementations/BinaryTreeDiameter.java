package dataStructuresImplementations;

/**
 * find diameter of a Binary Tree
 * The diameter of a tree (sometimes called the width) is the number 
 * of nodes on the longest path between two end nodes.
 * Runtime: O(n)
 * @author Utkarsh
 *
 */
public class BinaryTreeDiameter {

	static class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int num){
			this.val = num;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BinaryTree{
		Node root;
		
		/**
		 * slow solution
		 * finds longest path between two leaf nodes in a tree
		 * even though this looks simple, since we call height
		 * recursively makes this solution quadratic
		 * Runtime: O(n^2)
		 * @param node
		 * @return
		 */
		public int findDiameter(Node node){
			if(node == null)
				return 0;
			
			int d1 = findDiameter(node.left);
			int d2 = findDiameter(node.right);
			
			int h1 = height(node.left);
			int h2 = height(node.right);
			
			return Math.max(h1+h2+1, Math.max(d1,d2));
		}
		
		/**
		 * find height recursively
		 * runtime: O(n)
		 * @param node
		 * @return
		 */
		public int height(Node node){
			if(node == null)
				return 0;
			return Math.max(height(node.left), height(node.right))+1;
		}
		
		/**
		 * Best solution
		 * solution that finds height and diameter for each node for
		 * only that level so it does not involve double looping like 
		 * in the other solution making this a linear time approach
		 * Runtime: O(n)
		 * @param node
		 * @param height
		 * @return
		 */
		public int findDiameterWithHeight(Node node, Height height){
			if(node==null)
				return 0;
			Height lh = new Height();
			Height rh = new Height();
			
			int d1 = findDiameterWithHeight(node.left, lh);
			int d2 = findDiameterWithHeight(node.right, rh);
			
			height.h = Math.max(lh.h,rh.h)+1;
			return Math.max(lh.h + rh.h +1, Math.max(d1,d2));
		}
	}
	
	// needed to maintain height states in between calls
	static class Height{
		int h;
	}
	
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2); 
        bt.root.right = new Node(3); 
        bt.root.left.left = new Node(4); 
        bt.root.left.right = new Node(5); 
        System.out.println("Diameter: "+ bt.findDiameter(bt.root));
        System.out.println("Diameter with height method: "+bt.findDiameterWithHeight(bt.root, new Height()));
	}
}
