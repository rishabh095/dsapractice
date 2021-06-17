package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        int noOfVertices = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 4);
        printGraph(adj);
        topoLogicalSort(adj, noOfVertices);
    }

    private static void topoLogicalSort(List<List<Integer>> adj, int noOfVertices) {
        boolean[] visited = new boolean[noOfVertices];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }

    private static void dfs(List<List<Integer>> adj, int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v])
                dfs(adj, v, visited, stack);
        }
        stack.push(u);
    }

    private static void printGraph(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int u : adj.get(i)) {
                System.out.print(u + " ");
            }
            System.out.println();
        }
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}
