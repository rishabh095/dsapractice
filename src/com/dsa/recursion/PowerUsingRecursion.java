package com.dsa.recursion;

public class PowerUsingRecursion {
    public static void main(String[] args) {
        int n = 2;
        int p = 5;
        System.out.println(findPower(n, p));
    }

    private static int findPower(int n, int p) {
        if (p == 0)
            return 1;
        return n * findPower(n, p - 1);
    }
}
