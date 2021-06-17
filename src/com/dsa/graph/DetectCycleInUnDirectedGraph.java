package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInUnDirectedGraph {
    public static void main(String[] args) {
        int noOfVertices = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++)
            adj.add(new ArrayList<>());
        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,4);
        addEdge(adj,4,5);
        addEdge(adj,1,3);
        addEdge(adj,2,3);

        System.out.println(dfs(adj, noOfVertices));
    }

    private static boolean dfs(List<List<Integer>> adj, int noOfVertices) {
        boolean[] visited=new boolean[noOfVertices];
        for(int i=0;i<noOfVertices;i++){
            if(!visited[i]){
                if(dfsRec(adj,i,visited,-1))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfsRec(List<List<Integer>> adj, int source, boolean[] visited, int parent) {
        visited[source]=true;
        for(int v:adj.get(source)){
            if(!visited[v]){
                if(dfsRec(adj,v,visited,source))
                    return true;
            }else if(v != parent)
                return true;
        }
        return false;
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
