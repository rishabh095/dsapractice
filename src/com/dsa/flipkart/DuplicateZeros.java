package com.dsa.flipkart;

//https://leetcode.com/problems/duplicate-zeros/

import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        System.out.println(Arrays.toString(duplicateZeros(arr)));
    }

    private static int[] duplicateZeros(int[] arr) {
        int possibleNoOfZero = 0, length = arr.length - 1;
        for (int i = 0; i <= arr.length - possibleNoOfZero; i++) {
            if (arr[i] == 0) {
                if (i == arr.length - possibleNoOfZero) {
                    arr[length] = 0;
                    length--;
                    break;
                }
                possibleNoOfZero++;
            }
        }
        int last=length-possibleNoOfZero;
        for(int i=last;i>=0;i--){
            if(arr[i]==0){
                arr[i+possibleNoOfZero]=0;
                possibleNoOfZero--;
                arr[i+possibleNoOfZero]=0;
            }else
                arr[i+possibleNoOfZero]=arr[i];
        }

        return arr;
    }
}
