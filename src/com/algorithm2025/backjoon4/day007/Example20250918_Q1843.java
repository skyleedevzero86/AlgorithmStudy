package com.algorithm2025.backjoon4.day007;

import java.util.Arrays;

public class Example20250918_Q1843 { // 코딩테스트 연습 동적계획법(Dynamic Programming) 사칙연산
    public  int Example20250918_Q1843(String[] arr) {
        int n = arr.length;
        int[][] minDp = new int[n / 2 + 1][n / 2 + 1];
        int[][] maxDp = new int[n / 2 + 1][n / 2 + 1];
        for (int i = 0; i <= n / 2; i++) {
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            minDp[i][i] = Integer.parseInt(arr[i * 2]);
            maxDp[i][i] = Integer.parseInt(arr[i * 2]);
        }
        for (int c = 1; c <= n / 2; c++) {
            for (int i = 0; i <= n / 2 - c; i++) {
                int j = i + c;
                for (int k = i; k < j; k++) {
                    int left = maxDp[i][k];
                    int right = maxDp[k + 1][j];
                    if (arr[k * 2 + 1].equals("+")) {
                        maxDp[i][j] = Math.max(maxDp[i][j], left + right);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k + 1][j]);
                    } else {
                        maxDp[i][j] = Math.max(maxDp[i][j], left - minDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k + 1][j]);
                    }
                }
            }
        }
        return maxDp[0][n / 2];
    }
}
