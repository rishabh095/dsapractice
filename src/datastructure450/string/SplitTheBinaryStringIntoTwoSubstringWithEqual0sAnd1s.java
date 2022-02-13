package datastructure450.string;

// https://www.geeksforgeeks.org/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/

public class SplitTheBinaryStringIntoTwoSubstringWithEqual0sAnd1s {
    public static void main(String[] args) {
        String str = "01001101011";
        System.out.println(maxSubStr(str, str.length()));
    }

    // O(n) time complexity
    private static int maxSubStr(String str, int n) {
        int count0 = 0, count1 = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0')
                count0++;
            else
                count1++;
            if (count0 == count1)
                count++;
        }
        return count == 0 ? -1 : count;
    }
}
