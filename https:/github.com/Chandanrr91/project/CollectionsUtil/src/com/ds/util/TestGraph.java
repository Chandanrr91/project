package com.ds.util;

public class TestGraph {

	public static void main(String[] args) {

		Graph<Integer> graph = new Graph<Integer>(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);
		graph.addEdge(5, 3);
		graph.addEdge(5, 4);
		graph.addEdge(6, 4);
		DFS dfs = new DFS(graph, 0);
		Stack st = dfs.getPath(1);
		System.out.println("Stack out");
		st.traverse();
	}
}
