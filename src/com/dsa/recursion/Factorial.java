package com.dsa.recursion;

public class Factorial {
    public static void main(String[] args) {
        int n=4;
        System.out.println(findFactorial(n));
        System.out.println(findFactorialTailRecursive(n,1));
    }

    private static int findFactorialTailRecursive(int n, int k) {
        if(n==0)
            return k;
        return findFactorialTailRecursive(n-1,k*n);
    }

    private static int findFactorial(int n) {
        if(n==0)
            return 1;
        return n*findFactorial(n-1);
    }
}
