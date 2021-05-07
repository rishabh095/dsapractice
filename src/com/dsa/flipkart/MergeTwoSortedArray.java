package com.dsa.flipkart;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int m=3;
        int[] nums2={2,5,6};
        int n=3;
        System.out.println(Arrays.toString(merge(nums1,m,nums2,n)));
    }

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int last=m+n-1;
        m--;
        n--;
        while(m>-1 || n>-1){
            if(n<0)
                nums1[last--]=nums1[m--];
            else if(m<0)
                nums1[last--]=nums2[n--];
            else{
                if(nums1[m]>=nums2[n])
                    nums1[last--]=nums1[m--];
                else
                    nums1[last--]=nums2[n--];
            }
        }
        return nums1;
    }
}
