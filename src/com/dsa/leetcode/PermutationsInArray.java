package com.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsInArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permutations(nums);
        for (List<Integer> list : permutations)
            System.out.print(list + ",");
        System.out.println();
        List<List<Integer>> lists = permutationsBetterSolution(nums);
        for (List<Integer> list : lists)
            System.out.print(list + ",");
    }

    private static List<List<Integer>> permutationsBetterSolution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutationsBetterSolution(nums, result, 0, nums.length);
        return result;
    }

    private static void permutationsBetterSolution(int[] nums, List<List<Integer>> result, int start, int end) {
        if(start==end){
            List<Integer> list=new ArrayList<>();
            for(int num :nums)
                list.add(num);
            result.add(list);
        }
        for(int i=start;i<end;i++){
            int temp=nums[start];
            nums[start]=nums[i];
            nums[i]=temp;
            permutationsBetterSolution(nums,result,start+1,end);
            int temp1=nums[start];
            nums[start]=nums[i];
            nums[i]=temp1;
        }
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(nums, result, new ArrayList<>());
        return result;
    }

    private static void permutations(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                permutations(nums, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
