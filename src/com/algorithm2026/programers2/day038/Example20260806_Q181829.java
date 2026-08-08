package com.algorithm2026.programers2.day038;

public class Example20260806_Q181829 { // 등차수열의 특정한 항만 더하기

    public int solution(int a, int d, boolean[] included) {
        int n = included.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (included[i]) {
                sum += a + i * d;
            }
        }

        return sum;
    }
}