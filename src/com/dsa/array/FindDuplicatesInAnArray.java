package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 3};

        ArrayList<Integer> duplicates = findDuplicatesUsingHashMap(array, array.length);
        System.out.println("duplicates " + duplicates);

        ArrayList<Integer> duplicateNumbers = findDuplicatesUsingSorting(array, array.length);
        System.out.println("duplicates " + duplicateNumbers);
        
        int[] array1 = {2, 3, 1, 2, 3};
        ArrayList<Integer> duplicateNumber = findDuplicates(array1, array1.length);
        System.out.println("duplicates " + duplicateNumber);
    }

    // O(n) time complexity
    private static ArrayList<Integer> findDuplicates(int[] array, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = array[i] % n;
            array[index] += n;
        }
        //System.out.print("array "+Arrays.toString(array));
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if ((array[i] / n) > 1) {
                result.add(i);
                flag = 1;
            }
        }
        if (flag == 0) result.add(-1);
        return result;
    }

    // O(n lon n) time complexity
    private static ArrayList<Integer> findDuplicatesUsingSorting(int[] array, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 1; i < n; i++) {
            if (array[i] == array[i - 1] && !result.contains(array[i]))
                result.add(array[i]);
        }
        return result;
    }

    //Using extra space for HashMap.
    // O(n) time complexity and O(n) space complexity
    private static ArrayList<Integer> findDuplicatesUsingHashMap(int[] array, int length) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                result.add(entry.getKey());
        }
        return result;
    }
}
