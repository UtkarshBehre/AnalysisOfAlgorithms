package dataStructuresImplementations;

import java.util.LinkedList;

/**
 * Breadth First Search or BFS for a Graph
 * Runtime: O(V+E)
 * @author Utkarsh
 */
public class GraphBFS {
	int V;
	int start;
	LinkedList<Integer>[] adjList;
	
	@SuppressWarnings("unchecked")
	public GraphBFS(int vertices) {
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
	 * @param start
	 */
	public void printBFS(int start) {
		this.start = start;
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
	}
	
	public static void main(String[] args) {
		GraphBFS graph = new GraphBFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.printBFS(2);
	}
}
