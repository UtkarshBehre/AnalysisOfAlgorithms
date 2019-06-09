package sortingAlgorithms.implementations;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG).
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering 
 * of vertices such that for every directed edge uv, vertex u comes before v 
 * in the ordering. Topological Sorting for a graph is not possible if the graph 
 * is not a DAG.
 * NOTE: In topological sorting, we need to print a vertex before 
 * its adjacent vertices. And 1 graph can have multiple possible topological
 * order.
 * Runtime: O(V+E)
 * @author Utkarsh
 */
public class TopologicalSortingPractice {
	static class Graph{
		int V;
		LinkedList<Integer>[] adjVList;
		
		@SuppressWarnings("unchecked")
		public Graph(int v) {
			this.V = v;
			adjVList = new LinkedList[v];
			for(int i =0; i<v; i++)
				adjVList[i] = new LinkedList<Integer>();
		}
		
		public void addEdge(int src, int dest) {
			adjVList[src].add(dest);
		}
		
		/**
		 * prints the elements of the graph in topological order using stack
		 * to push all elements first in reverse and then pop and print each
		 * of them.
		 * Runtime: O(V+E)
		 */
		public void printTopologicalSort() {
			boolean[] visited = new boolean[V];
			Stack<Integer> stack= new Stack<Integer>();
			for(int i = 0; i<V; i++)
				if(!visited[i])
					DFSRec(i, visited, stack);
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
		}
		
		/**
		 * Depth first search used to go through each adjacent vertices before
		 * pushing a vertex to the stack
		 * RUntime: O(V+E)
		 * @param vertex = current vertex
		 * @param visited = already visited vertices
		 * @param stack = stack with reverse topological order to pop at end
		 * @return
		 */
		public boolean DFSRec(int vertex, boolean[] visited, Stack<Integer> stack) {
			if(visited[vertex]) {
				return false;
			}
			visited[vertex] = true;
			for(int v : adjVList[vertex])
				if(!visited[v])
					DFSRec(v, visited, stack);
			stack.push(vertex);	
			return false;
		}
	}
	
	public static void main(String[] args) {
		Graph g1 = new Graph(6); 
        g1.addEdge(5, 2); 
        g1.addEdge(5, 0); 
        g1.addEdge(4, 0); 
        g1.addEdge(4, 1); 
        g1.addEdge(2, 3); 
        g1.addEdge(3, 1); 
        /*
        	5 -> 2 -> 3 -> 1 , 5 -> 0
        	4 -> 1 -> , 4 -> 0    
        */
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g1.printTopologicalSort();
        
        // another example to make it clear
        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(2, 4);
        g2.addEdge(5, 6);
        g2.addEdge(6, 3);
        /*
            0 -> 1, 0 -> 2 -> 4
            5 -> 6 -> 3
         */
        System.out.println("\nFollowing is a Topological " + 
                "sort of the given graph"); 
        g2.printTopologicalSort();
	}
}
