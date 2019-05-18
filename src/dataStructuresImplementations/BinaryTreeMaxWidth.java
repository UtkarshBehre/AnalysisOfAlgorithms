package dataStructuresImplementations;

import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreeMaxWidth {
	static class Node{
		int val;
		Node left;
		Node right;

		public Node(int num) {
			val = num;
		}
		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}

	static class BinaryTree{
		Node root;

		/**
		 * evaluates the maximum width avaiable in the tree using hashmap to
		 * store <level,width> pair and increment width as the new node is found
		 * Simple array of integers can also be used, but that required evaluating
		 * height before going for width, 
		 * for that level
		 * Runtime: O(n)
		 */
		public int maxWidth() {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			// map will have level,width pairs after width() call
			width(root, 1, map);
			int max = 0;
			for(int x: map.values()) {
				max = Math.max(max, x);
			}
			return max;
		}

		private void width(Node node, int level, HashMap<Integer,Integer> map) {
			if(node==null)
				return;
			// array or arrayList can also be used instead of HashMap
			if(map.containsKey(level)) {
				map.put(level, map.get(level)+1);
			}else
				map.put(level, 1);
			width(node.left, level+1, map); 
			width(node.right, level+1, map);
		}

		/**
		 * Uses levelOrder traversal technique using queue to evaluate maximum width
		 * Runtime: O(n)
		 * @param root
		 */
		public int maxWidthUsingQueue(Node root) {
			if(root == null)
				return 0;
			
			java.util.Queue<Node> nodes = new LinkedList<Node>();
			nodes.add(root);
			int maxWidth = 0;
			int count = 0;
			// outer loop is just to keep count of max nodes in one level
			while(!nodes.isEmpty()) {
				count = nodes.size();
				maxWidth = Math.max(maxWidth, count);
				// dequeues the nodes and enqueues its children until that 
				// level is done denoted by count
				while(count-->0) {
					Node tmp = (Node)nodes.poll();
					if(tmp.left!=null)
						nodes.add(tmp.left);
					if(tmp.right!=null)
						nodes.add(tmp.right);
				}
			}
			return maxWidth;
		}
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 

		/* 
        Constructed bunary tree is: 
              1 
            /  \ 
           2    3 
         /  \    \ 
        4   5     8  
                 /  \ 
                6   7 
		 */
		//set 1
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.right = new Node(8); 
		tree.root.right.right.left = new Node(6); 
		tree.root.right.right.right = new Node(7); 
		
		//set2
		/*
		Constructed bunary tree is: 
		        1 
		      /  \ 
		     2    3 
		   /  \    \ 
		  4   5     8  
         /  \ 
      	6   7 
		*/
		tree.root = null;
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(8);
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.right = new Node(7);
		
		System.out.println("Maximum width is " + tree.maxWidthUsingQueue(tree.root)); 
	}
}
