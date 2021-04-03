package com.dsa.leetcode;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String str = ")(()())";//"(()";
        System.out.println(longestValidParenthesesNaiveSolution(str));
        System.out.println(longestValidParentheses(str));
        System.out.println(longestValidParenthesesWithOutStack(str));
    }

    // O(n*n*n)
    private static int longestValidParenthesesNaiveSolution(String str) {
        int maxLen=0;
        for(int i=0;i<str.length();i++){
            for(int j=i+2;j<=str.length();j=j+2){
               // System.out.println(j+" "+str.subSequence(i,j));
                if(isValid(str.subSequence(i,j)))
                    maxLen=Math.max(maxLen,j-i);
            }
        }
        return maxLen;
    }

    private static boolean isValid(CharSequence str) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
                s.push('(');
            else if( !s.isEmpty() && s.peek()=='(')
                s.pop();
            else
                return false;
        }
        return s.isEmpty();
    }

    public static int longestValidParenthesesWithOutStack(String s) {
        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxLength;
    }


    private static int longestValidParentheses(String str) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(')
                stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    maxLen=Math.max(maxLen,i- stack.peek());
            }
        }
        return maxLen;
    }
}
