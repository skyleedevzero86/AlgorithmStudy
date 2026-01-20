package com.algorithm2026.programers.day007;

import java.util.LinkedList;
import java.util.Queue;

public class Example20260120_Q1 {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30
        System.out.println(stack.top()); // 20
        System.out.println(stack.pop()); // 20
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.pop()); // 10
        System.out.println(stack.isEmpty()); // true
    }
}


class StackUsingQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // push: O(n)
    public void push(int x) {

        q2.offer(x);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.poll();
    }

    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
