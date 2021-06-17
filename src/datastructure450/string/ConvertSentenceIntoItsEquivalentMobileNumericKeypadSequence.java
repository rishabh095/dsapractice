package datastructure450.string;

// https://www.geeksforgeeks.org/convert-sentence-equivalent-mobile-numeric-keypad-sequence/

public class ConvertSentenceIntoItsEquivalentMobileNumericKeypadSequence {
    static String[] sequence = {"2", "22", "222",
            "3", "33", "333",
            "4", "44", "444",
            "5", "55", "555",
            "6", "66", "666",
            "7", "77", "777", "7777",
            "8", "88", "888",
            "9", "99", "999", "9999"};

    public static void main(String[] args) {
        String input = "GEEKSFORGEEKS";
        System.out.println(printSequence(input, input.length()));
    }

    // O(n) time complexity
    private static String printSequence(String input, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == ' ')
                sb.append(0);
            else
                sb.append(sequence[input.charAt(i) - 'A']);
        }
        return sb.toString();
    }
}
