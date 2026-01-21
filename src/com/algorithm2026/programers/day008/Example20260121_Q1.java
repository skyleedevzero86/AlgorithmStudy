package com.algorithm2026.programers.day008;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        moveIfNeeded();
        return outStack.pop();
    }

    public int peek() {
        moveIfNeeded();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}



public class Example20260121_Q1 {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println(q.pop());   // 1
        System.out.println(q.peek());  // 2
        System.out.println(q.pop());   // 2
        System.out.println(q.empty()); // false
    }
}
