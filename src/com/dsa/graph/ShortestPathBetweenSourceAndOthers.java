package com.dsa.graph;

import java.util.*;

public class ShortestPathBetweenSourceAndOthers {
    public static void main(String[] args) {
        int noOfVertices = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);

        System.out.println(Arrays.toString(bfs(adj, noOfVertices, 0)));
    }

    private static int[] bfs(List<List<Integer>> adj, int noOfVertices, int s) {
        int[] dist = new int[noOfVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s]=0;
        boolean[] visited=new boolean[noOfVertices];
        Queue<Integer> queue=new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while (!queue.isEmpty()){
            int u= queue.poll();
            for(int v:adj.get(u)){
                if(!visited[v]){
                    dist[v]=dist[u]+1;
                    visited[v]=true;
                    queue.add(v);
                }
            }
        }
        return dist;
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
