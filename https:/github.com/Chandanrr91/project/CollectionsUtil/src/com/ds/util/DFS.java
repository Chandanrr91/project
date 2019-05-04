package com.ds.util;

public class DFS {

	private boolean[] marked;
	int source;
	int[] edgeTo;

	public DFS(Graph graph, int source) {

		this.source = source;
		marked = new boolean[(int) graph.getVertices()];
		edgeTo = new int[(int) graph.getVertices()];
		dfs(graph, source);
		edgeTo[source] = source;

	}

	private void dfs(Graph graph, int source2) {

		marked[source2] = true;
		System.out.println(source2);
		for (Object w : graph.getAdj(source2)) {
			int vert = (int) w;
			if (!marked[vert]) {
				edgeTo[vert] = source2;
				dfs(graph, vert);
			}
		}
	}

	public Stack getPath(int dest) {

		Stack st = new Stack();
		int temp = dest;
		while (temp != source) {
			st.push(temp);
			temp = edgeTo[temp];
		}
		st.push(source);
		return st;
	}

}
