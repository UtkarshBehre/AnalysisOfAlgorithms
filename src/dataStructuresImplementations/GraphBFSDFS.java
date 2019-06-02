package dataStructuresImplementations;

import java.util.LinkedList;

/**
 * Breadth First Search or BFS and Depth First Search or DFS for a Graph
 * Runtime: O(V+E)
 * @author Utkarsh
 */
public class GraphBFSDFS {
	int V;
	LinkedList<Integer>[] adjList;
	
	@SuppressWarnings("unchecked")
	public GraphBFSDFS(int vertices) {
		this.V = vertices;
		adjList = new LinkedList[vertices];
		for(int i = 0; i<V; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
	
	/**
	 * breadth first traversal using queue
	 * Runtime: O(V+E)
	 */
	public void printBFS(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		boolean[] visited = new boolean[V];
		visited[start] = true;
		System.out.print("Breadth first traversal: ");
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print(vertex+" ");
			for(int adjV : adjList[vertex]) {
				if(!visited[adjV]) {
					queue.add(adjV);
					visited[adjV] = true;
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * Depth first traversal using recursion and start node
	 * Runtime: O(V+E)
	 */
	public void printDFS(int start) {
		boolean[] visited = new boolean[V];		
		System.out.print("Depth first traversal: ");
		printDFSRec(start, visited);	
		System.out.println();
	}
	
	/**
	 * Complete depth first traversal using recursion without start node
	 * so it reaches all nodes present even if disconnected
	 * Runtime: O(V+E)
	 */
	public void printDFSComplete() {
		boolean[] visited = new boolean[V];
		System.out.print("Complete depth first traversal: ");
		for(int i = 0; i<V; i++) {
			if(!visited[i])
				printDFSRec(i, visited);
		}
	}
	
	/**
	 * recursive method to print current vertex and recall for each 
	 * non visited adjacent node
	 * Runtime: O(V+E)
	 */
	public void printDFSRec(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex+" ");
		for(int adjv : adjList[vertex]) {
			if(!visited[adjv]) {
				printDFSRec(adjv, visited);
			}
		}
	}
	
	// tester code
	public static void main(String[] args) {
		GraphBFSDFS graph = new GraphBFSDFS(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.printBFS(2);
		graph.printDFS(2);
		graph.printDFSComplete(); 
	}
}
