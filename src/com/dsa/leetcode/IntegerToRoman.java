package com.dsa.leetcode;

// 12. Integer to Roman
// https://leetcode.com/problems/integer-to-roman/

public class IntegerToRoman {
    static String[] symbol = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    static int[] value = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public static void main(String[] args) {
        int num = 100;
        System.out.println(intToRoman(num));
    }

    private static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = value.length - 1;

        //Logic
        //Subtract num with value[i] till num is greater than Zero,
        // if num is greater/equal to value[i], and append Corresponding symbol
        // else just move lower value
        while(num>0 && i>=0){
            if(num<value[i])
                i--;
            else{
                num -=value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}
