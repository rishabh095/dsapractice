package datastructure450.stackandqueue;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr={2, 5, -3, -4, 6, 7, 2};
        System.out.println(Arrays.toString(nextGreater(arr,arr.length)));
    }

    private static int[] nextGreater(int[] arr, int n) {
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();
        result[n-1]=-1;
        stack.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){
           while(!stack.isEmpty() && stack.peek()<=arr[i])
               stack.pop();
           result[i]=stack.isEmpty()?-1:stack.peek();
           stack.push(arr[i]);
        }
        return result;
    }
}
