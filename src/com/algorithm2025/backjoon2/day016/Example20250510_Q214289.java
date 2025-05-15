package com.algorithm2025.backjoon2.day016;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Example20250510_Q214289 { // 2023 현대모비스 알고리즘 경진대회 예선 에어컨 문제

    public int Example20250510_Q214289(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        final int INF = 1000 * 100;
        final int OFFSET = 10;

        temperature += OFFSET;
        t1 += OFFSET;
        t2 += OFFSET;

        int len = onboard.length;
        int[][] DP = new int[len][51];
        Arrays.stream(DP).forEach(row -> Arrays.fill(row, INF));
        DP[0][temperature] = 0;

        final int flag = (temperature > t2) ? -1 : 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= 50; j++) {
                if (onboard[i] == 0 || (t1 <= j && j <= t2)) {
                    int stay = (j == temperature) ? DP[i - 1][j] : INF;
                    int inc = (j + flag >= 0 && j + flag <= 50) ? DP[i - 1][j + flag] : INF;
                    int dec = (j - flag >= 0 && j - flag <= 50) ? DP[i - 1][j - flag] + a : INF;
                    int idle = (t1 <= j && j <= t2) ? DP[i - 1][j] + b : INF;

                    DP[i][j] = Math.min(Math.min(stay, inc), Math.min(dec, idle));
                }
            }
        }

        return Arrays.stream(DP[len - 1]).min().orElse(INF);
    }
}
