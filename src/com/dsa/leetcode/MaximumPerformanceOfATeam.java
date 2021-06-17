package com.dsa.leetcode;

import javafx.util.Pair;

import java.util.*;

// https://leetcode.com/problems/maximum-performance-of-a-team/

public class MaximumPerformanceOfATeam {
    public static void main(String[] args) {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        System.out.println(maxPerformance(n, speed, efficiency, k));
    }

    private static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //int modulo = (int) Math.pow(10, 9) + 7;   as per leetcode solution
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new Pair<>(speed[i], efficiency[i]));
        System.out.println(list);
        //Collections.sort(list,(o1, o2) -> o1.getValue() - o2.getValue());
        //list.sort(Comparator.comparingInt(Pair::getValue));
        //list.sort(Comparator.comparing(o -> -o.getValue()));
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println(list);
        PriorityQueue<Integer> speedQueue = new PriorityQueue<>();
        //long result=0,speedSum=0;
        int speedSum = 0, result = 0;
        for (Pair<Integer, Integer> p : list) {
            Integer currSpeed = p.getKey();
            Integer currEfficiency = p.getValue();
            if (speedQueue.size() == k)
                speedSum -= speedQueue.poll();
            speedQueue.add(currSpeed);
            speedSum += currSpeed;
            result = Math.max(result, speedSum * currEfficiency);
        }
        // return (int) (result % modulo);
        return result;
    }
}
