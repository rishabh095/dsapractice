package com.dsa.recursion;

/*
Lucky numbers are subset of integers. Rather than going into much theory, let us see the process of arriving at lucky numbers,
Take the set of integers
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,……
First, delete every second number, we get following reduced set.
1, 3, 5, 7, 9, 11, 13, 15, 17, 19,…………
Now, delete every third number, we get
1, 3, 7, 9, 13, 15, 19,….….
Continue this process indefinitely……
Any number that does NOT get deleted due to above process is called “lucky”.

Example 1:
Input:
N = 5
Output: 0
Explanation: 5 is not a lucky number
as it gets deleted in the second
iteration.

Example 2:
Input:
N = 19
Output: 1
Explanation: 19 is a lucky number
Your Task:
You don't need to read input or print anything. You only need to complete the function isLucky() that takes N as parameter and returns either False if the N is not lucky else True.

*/

public class LuckyNumbers {
    public static void main(String[] args) {
        int num = 19;
        System.out.println(isLucky(num));
    }

    private static boolean isLucky(int num) {
        return luckyCheck(num, 2);
    }

    private static boolean luckyCheck(int num, int counter) {
        if (num >= counter) {
            if (num % counter == 0)
                return false;
            // new position for num to check
            num = num - num / counter;
            counter++;
            return luckyCheck(num, counter);
        } else
            return true;
    }
}
