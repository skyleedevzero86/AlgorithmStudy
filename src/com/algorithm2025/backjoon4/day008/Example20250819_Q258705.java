package com.algorithm2025.backjoon4.day008;

public class Example20250819_Q258705 { //코딩테스트 연습 2024 KAKAO WINTER INTERNSHIP  산 모양 타일링
    public static int Example20250819_Q258705(int n, int[] tops) {
        final int MOD = 10007;
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        a[0] = 0;
        b[0] = 1;

        for (int k = 1; k <= n; k++) {
            if (tops[k - 1] == 1) {
                a[k] = (a[k - 1] + b[k - 1]) % MOD;
                b[k] = (2 * a[k - 1] + 3 * b[k - 1]) % MOD;
            } else {
                a[k] = (a[k - 1] + b[k - 1]) % MOD;
                b[k] = (a[k - 1] + 2 * b[k - 1]) % MOD;
            }
        }

        return (a[n] + b[n]) % MOD;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] tops = {1, 0, 1, 1};
        int result = Example20250819_Q258705(n, tops);
        System.out.println(result);
    }
}
