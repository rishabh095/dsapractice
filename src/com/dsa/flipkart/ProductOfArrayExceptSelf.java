package com.dsa.flipkart;

// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    private static int[] productExceptSelf(int[] arr) {
        int[] result=new int[arr.length];
        result[0]=1;
        for(int i=1;i<arr.length;i++)
            result[i]=result[i-1]*arr[i-1];
        int r=1;
        for(int i=arr.length-1;i>=0;i--){
            result[i] *=r;
            r*=arr[i];
        }
        return result;
    }
}
