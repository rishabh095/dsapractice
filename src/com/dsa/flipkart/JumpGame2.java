package com.dsa.flipkart;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr={2,3,1,1,4};
        //System.out.println(jumpCountUsingRecursion(arr,arr.length));
        System.out.println(jumpCountUsingDP(arr,arr.length));
    }

    private static int jumpCountUsingDP(int[] arr, int n) {
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++)
            dp[i]=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(j+arr[j]>=i){
                    if(dp[j] !=Integer.MAX_VALUE)
                        dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }

    static int jumpCountUsingRecursion(int[] nums,int n){
        if(n==1)
            return 0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(i+nums[i]>=n-1){
                int sub_res=jumpCountUsingRecursion(nums,i+1);
                if(sub_res !=Integer.MAX_VALUE)
                    res=Math.min(res,sub_res);
            }
        }
        return res;

    }
}
