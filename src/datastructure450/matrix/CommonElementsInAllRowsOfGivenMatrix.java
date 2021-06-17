package datastructure450.matrix;

// https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElementsInAllRowsOfGivenMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 1, 4, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {8, 1, 2, 7, 9},
        };
        System.out.println(printCommonElements(arr, arr.length, arr[0].length));
    }

    private static List<Integer> printCommonElements(int[][] arr, int R, int C) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < C; j++)
            map.put(arr[0][j], 1);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map.containsKey(arr[i][j]) && map.get(arr[i][j]) == i) {
                    map.put(arr[i][j], i + 1);
                    if (i == R - 1)
                        list.add(arr[i][j]);
                }
            }
        }
        return list;
    }
}
