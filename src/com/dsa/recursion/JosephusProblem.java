package com.dsa.recursion;

// circular table n person kth person out position of last person
public class JosephusProblem {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        System.out.println(findPosition(n, k)); // θ(n)
    }

    // index's are not zero based means index starts from 1.
    private static int findPosition(int n, int k) {
        return JosephusPosition(n, k) + 1;
    }

    // this function will return the position based on index starts from 0.
    private static int JosephusPosition(int n, int k) {
        if (n == 1)
            return 0;
        return (JosephusPosition(n - 1, k) + k) % n;
    }
}
