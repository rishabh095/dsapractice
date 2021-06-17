package datastructure450.string;

// https://leetcode.com/problems/count-and-say/

public class CountAndSay {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }

    // O(n) time complexity
    private static String countAndSay(int n) {
        if (n == 1)
            return "1";
        String countAndSay = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int prev = 0, pos = 1;
        while (pos < countAndSay.length()) {
            if (countAndSay.charAt(pos) != countAndSay.charAt(pos - 1)) {
                sb.append(pos - prev).append(countAndSay.charAt(pos - 1));
                prev = pos;
            }
            pos++;
        }
        sb.append(pos - prev).append(countAndSay.charAt(pos - 1));
        return sb.toString();
    }
}
