package datastructure450.string;

// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

public class AllPermutationsOfAGivenString {
    public static void main(String[] args) {
        String str = "ABC";
        permutation(str, 0, str.length() - 1);
    }

    // O(n*n!) time complexity
    private static void permutation(String str, int low, int high) {
        if (low == high)
            System.out.print(str + " ");
        else {
            for (int i = low; i <= high; i++) {
                str = swap(str, low, i);
                permutation(str, low + 1, high);
                str = swap(str, low, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
