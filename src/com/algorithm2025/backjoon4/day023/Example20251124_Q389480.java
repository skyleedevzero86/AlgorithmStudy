package com.algorithm2025.backjoon4.day023;

import java.util.Arrays;

public class Example20251124_Q389480 { // 코딩테스트 연습 2025 프로그래머스 코드챌린지 2차 예선 완전범죄
    public int solution(int[][] info, int n, int m) {
        int len = info.length;

        long[][] dp = new long[len + 1][121];


        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;


        for (int i = 1; i <= len; i++) {
            int traceA = info[i - 1][0];
            int traceB = info[i - 1][1];

            for (int a = 0; a <= 120; a++) {

                if (dp[i - 1][a] == -1) continue;


                int newTraceA = a + traceA;
                if (newTraceA <= 120) {
                    if (dp[i][newTraceA] == -1 || dp[i][newTraceA] > dp[i - 1][a]) {
                        dp[i][newTraceA] = dp[i - 1][a];
                    }
                }


                long newTraceB = dp[i - 1][a] + traceB;
                if (dp[i][a] == -1 || dp[i][a] > newTraceB) {
                    dp[i][a] = newTraceB;
                }
            }
        }


        int result = -1;
        for (int a = 0; a < n; a++) {
            if (dp[len][a] != -1 && dp[len][a] < m) {
                result = a;
                break;
            }
        }

        return result;
    }

}
