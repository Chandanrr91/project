package com.ds.util;

import java.util.LinkedList;;

public class Graph<T> {

	private T vertices;
	LinkedList<T>[] adj;
	private int edge = 0;

	public Graph(T vertices) {
		this.vertices = vertices;
		this.adj = new LinkedList[(int) vertices];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList();
		}
	}

	public void addEdge(T vertice, T edge) {

		adj[(int) vertice].add(edge);
		adj[(int) edge].add(vertice);
		this.edge++;

	}

	public Iterable<T> getAdj(int vertice) {

		return adj[vertice];
	}

	public T getVertices() {
		return vertices;
	}

	public int getEdge() {
		return edge;
	}

}
