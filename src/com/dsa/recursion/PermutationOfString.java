package com.dsa.recursion;

public class PermutationOfString {
    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0, str.length()-1);
    }

    private static void permute(String str, int start, int end) {
        if(start==end)
            System.out.print(str+" ");
        else{
            for(int i=start;i<=end;i++){
                str=swap(str,start,i);
                permute(str,start+1,end);
                str=swap(str,start,i);
            }
        }
    }

    private static String swap(String str, int start, int i) {
        char temp;
        char[] charArr=str.toCharArray();
        temp=charArr[i];
        charArr[i]=charArr[start];
        charArr[start]=temp;
        return String.valueOf(charArr);
    }
}
