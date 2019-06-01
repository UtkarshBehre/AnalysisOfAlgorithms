package dataStructuresImplementations;

import java.util.LinkedList;

/**
 * graph adjacency list implementation, addEdge
 * Runtime: O(1)
 * @author Utkarsh
 */
public class Graph {
	int V;
	LinkedList<Integer>[] adjList;
	
	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.V = vertices;
		adjList = new LinkedList[vertices];
		
		for(int i = 0; i<V; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	/**
	 * adds edge considering undirected graph
	 * @param source
	 * @param destination
	 */
	public void addEdge(int source, int destination) {
		adjList[source].add(destination);
		adjList[destination].add(source);
	}
	
	public void print() {
		for(int i = 0; i<V; i++) {
			System.out.print("Vertex:"+i+" | adj list:");
			for(int vertex : adjList[i]) {
				System.out.print(vertex+", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.print();
	}
}
