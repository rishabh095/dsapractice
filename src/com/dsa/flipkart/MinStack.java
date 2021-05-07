package com.dsa.flipkart;

import java.util.Stack;

// get minimum value from stack in O(1) time
public class MinStack {
    static Stack<Integer>  stack;
    static Stack<Integer> minStack;
    public static void main(String[] args) {
        stack=new Stack<>();
        minStack=new Stack<>();
        insert(8);
        insert(10);
        System.out.println(getMin());
        insert(20);
        delete();
        insert(6);
        System.out.println(getMin());
        delete();
        delete();
        System.out.println(getMin());
        delete();
        System.out.println(getMin());
        insert(10);
        System.out.println(getMin());
        insert(2);
        System.out.println(getMin());
        delete();
        System.out.println(getMin());
    }

    private static void delete() {
        if(!stack.isEmpty()){
            int val=stack.pop();
            if(minStack.peek()==val){
                minStack.pop();
            }
        }
    }

    private static int getMin() {
        if(!minStack.isEmpty())
            return minStack.peek();
        else
            return -1;
    }

    private static void insert(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            if(minStack.isEmpty())
                minStack.push(val);
        }else {
            stack.push(val);
            if (minStack.peek() > val)
                minStack.push(val);
        }
    }
}
