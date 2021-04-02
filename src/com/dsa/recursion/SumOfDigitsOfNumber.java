package com.dsa.recursion;

public class SumOfDigitsOfNumber {
    public static void main(String[] args) {
        int n = 9987;//253;
        System.out.println(sumOfDigits(n));
    }

    private static int sumOfDigits(int n) {
        if (n < 10)
            return n;
        return (n % 10) + sumOfDigits(n / 10);
    }
}
