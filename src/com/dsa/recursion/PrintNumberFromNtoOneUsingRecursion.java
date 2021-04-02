package com.dsa.recursion;

public class PrintNumberFromNtoOneUsingRecursion {
    public static void main(String[] args) {
        int n=5;
        printNumbers(n);
        System.out.println();
        printReverseNumbers(n);
    }

    private static void printReverseNumbers(int n) {
        if(n==0)
            return;
        printReverseNumbers(n-1);
        System.out.print(n+" ");
    }

    private static void printNumbers(int n) {
        if(n==0)
            return;
        System.out.print(n+" ");
        printNumbers(n-1);
    }
}
