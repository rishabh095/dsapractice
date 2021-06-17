package datastructure450.string;

// https://leetcode.com/problems/rotate-string/

public class IsRotateString {

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "cdeab";
        System.out.println(isRotateString(str1, str2));
    }

    private static boolean isRotateString(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.length() == 0) {
            return true;
        }
        char ch;
        ch = str1.charAt(0);
        int i = 0;
        int len = str1.length();
        while (i < len) {
            if (ch == str2.charAt(i)) {
                boolean test = true;
                for (int k = 0; k < len; k++) {
                    if (str1.charAt(k) != str2.charAt((k + i) % len)) {
                        test = false;
                        break;
                    }
                }
                if (test)
                    return true;
            }
            i++;
        }
        return false;
    }
}
