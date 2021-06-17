package com.dsa.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 4, 5};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        int k = 3;
        System.out.println(check(list, k));
        System.out.println(1+2+"3"+2+1);
    }

    private static int check(List<Integer> list, int k) {
        int res = 0;
        for (int i = 0; i <= list.size() - k; i++) {
            int j;
            for (j = 0; j < k - 1; j++) {
                if (list.get(i + j) >= list.get(i + j + 1))
                    break;
            }
            if (j == k - 1) {
                res++;

            }
        }
        return res;
    }
}

