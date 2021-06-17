package datastructure450.string;

// https://leetcode.com/problems/integer-to-roman/

public class IntegerToRoman {
    static String[] symbol = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    static int[] value = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public static void main(String[] args) {
        int num = 4;
        System.out.println(intToRoman(num));
    }

    private static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = value.length - 1;
        while (num > 0 && i >= 0) {
            if (num < value[i])
                i--;
            else {
                num -= value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}
