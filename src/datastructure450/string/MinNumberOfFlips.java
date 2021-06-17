package datastructure450.string;

// https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/

public class MinNumberOfFlips {
    public static void main(String[] args) {
        String str = "001";
        System.out.println(minFlips(str));
    }

    // O(n) time complexity
    private static int minFlips(String str) {
        return Math.min(minFlipsWithExpected(str, '0'), minFlipsWithExpected(str, '1'));
    }

    private static int minFlipsWithExpected(String str, char expected) {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != expected)
                flipCount++;
            expected = getExpected(expected);
        }
        return flipCount;
    }

    private static char getExpected(char expected) {
        return expected == '0' ? '1' : '0';
    }
}
