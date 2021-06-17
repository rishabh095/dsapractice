package datastructure450.string;

// https://www.geeksforgeeks.org/print-subsequences-string/

public class PrintSubsequencesString {
    public static void main(String[] args) {
        String str = "cab";
        printSubSeq(str, str.length(), -1, "");
    }

    // O(n*n!) time complexity (n! permutation)
    private static void printSubSeq(String str, int n, int index, String curr) {
        if (index == n)
            return;
        if (curr != null && !curr.trim().isEmpty())
            System.out.print(curr + "  ");
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            printSubSeq(str, n, i, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
