package com.algorithm2025.backjoon3.day001;

public class Example20250620_Q_L922 { // Leetcode 922 Sort Array By Parity II

    public int[] sortArrayByparity(int[] nums) {
        int[] ans = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                ans[evenIndex] = num;
                evenIndex += 2;
            } else {
                ans[oddIndex] = num;
                oddIndex += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Example20250620_Q_L922 es = new Example20250620_Q_L922();
        int[] result = es.sortArrayByparity(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
