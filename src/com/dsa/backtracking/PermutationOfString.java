package com.dsa.backtracking;

// Permutation of a String which do not contains "AB"
public class PermutationOfString {
    public static void main(String[] args) {
        String str = "ABC";
        permutationsOfString(str, 0, str.length() - 1);
        System.out.println();
        // not all permutation will be generated, eliminate permutations which have "AB"
        // as string with the help of isSafe function.
        permutationsOfStringUsingBackTracking(str, 0, str.length() - 1);
        fun(6);
    }

    private static void fun(int a) {
        for(int i=1;i<a;i++)
            System.out.print(rec(i));
    }

    private static int rec(int i) {
        if(i<=2)
            return 0;
        if(i==3)
            return 1;
        else
            return rec(i-1)+rec(i-2)+rec(i-3);
    }

    private static void permutationsOfStringUsingBackTracking(String str, int start, int end) {
        if (start == end) {
            System.out.print(str + " ");
            return;
        } else {
            for (int i = start; i <= end; i++) {
                if (isSafe(str, start, end, i)) {
                    str = swap(str.toCharArray(), start, i);
                    permutationsOfStringUsingBackTracking(str, start + 1, end);
                    str = swap(str.toCharArray(), start, i);
                }
            }
        }
    }

    private static boolean isSafe(String str, int start, int end, int i) {
        if (start != 0 && str.charAt(start - 1) == 'A' && str.charAt(i) == 'B')
            return false;
        if (end == start + 1 && str.charAt(i) == 'A' && str.charAt(start) == 'B')
            return false;
        return true;
    }

    private static void permutationsOfString(String str, int start, int end) {
        if (start == end) {
            if (!str.contains("AB"))
                System.out.print(str + " ");
            return;
        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str.toCharArray(), start, i);
                permutationsOfString(str, start + 1, end);
                str = swap(str.toCharArray(), start, i);
            }
        }
    }

    private static String swap(char[] strArray, int start, int end) {
        char temp = strArray[start];
        strArray[start] = strArray[end];
        strArray[end] = temp;
        return String.valueOf(strArray);
    }


}
