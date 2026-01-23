package com.algorithm2026.programers.day009;

public class Example202601123_Q1 { //연습문제 쌍둥이 빌딩 숲

    public static int solution(int n, int count) {
        long[][] arr = new long[n + 1][n + 2];
        long MOD = 1000000007;

        arr[1][1] = 1;

        for (int x = 2; x <= n; x++) {
            for (int y = 1; y <= x+1; y++) {
                long temp = 0;

                if (y == 1) {
                    temp = arr[x - 1][y] * (2 * (x - 1));
                } else if (y > 1 && y <= x) {
                    temp = arr[x - 1][y] * (2 * (x - 1)) + arr[x - 1][y - 1];
                } else {
                    temp = arr[x - 1][y - 1];
                }

                arr[x][y] = temp % MOD;
            }
        }

        return (int) (arr[n][count] % MOD);
    }
}
