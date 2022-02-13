package datastructure450.backtracking;

// https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/

import java.util.Arrays;

public class MColoringProblem {
    public static void main(String[] args) {
        boolean[][] graph = {
                {false, true, true, true},
                {true, false, true, false},
                {true, true, false, true},
                {true, false, true, false},
        };
        int m = 3;
        solveMColoring(graph, m);
        int[][] edges = {{1, 2}, {2, 3}, {1, 3}};//{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}};
        boolean[][] graph1 = new boolean[edges.length][edges.length];
        for (int[] edge : edges) {
            crateGraph(graph1, edge[0] - 1, edge[1] - 1);
        }
        solveMColoring(graph1, 2);
    }

    private static void crateGraph(boolean[][] graph, int u, int v) {
        graph[u][v] = true;
        graph[v][u] = true;
    }

    // O(m^v) time complexity and O(v) space complexity
    private static void solveMColoring(boolean[][] graph, int m) {
        int[] color = new int[graph.length];
        if (!graphColoring(graph, m, 0, color))
            System.out.println("No Solution exists");
    }

    private static boolean graphColoring(boolean[][] graph, int m, int i, int[] color) {
        if (i == graph.length) {
            if (isSafe(graph, color)) {
                System.out.println(Arrays.toString(color));
                return true;
            }
            return false;
        }
        for (int j = 1; j <= m; j++) {
            color[i] = j;
            if (graphColoring(graph, m, i + 1, color))
                return true;
            color[i] = 0;
        }
        return false;
    }

    private static boolean isSafe(boolean[][] graph, int[] color) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph.length; j++) {
                if (graph[i][j] && color[i] == color[j])
                    return false;
            }
        }
        return true;
    }

    private static void printGraph(boolean[][] graph) {
        for (boolean[] row : graph)
            System.out.println(Arrays.toString(row));
    }
}
