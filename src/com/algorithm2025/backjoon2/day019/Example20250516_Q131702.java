package com.algorithm2025.backjoon2.day019;

import java.util.Arrays;

public class Example20250516_Q131702 { //코딩테스트 연습 연습문제  고고학 최고의 발견

    public int Example20250516_Q131702(int[][] clockHands) {
        int N = clockHands.length;
        int answer = Integer.MAX_VALUE;

        int[][] copyArr;
        int cnt, a;
        for (int i = 0; i < Math.pow(4, N); i++) {
            copyArr = new int[N][N];
            for (int j = 0; j < N; j++) {
                copyArr[j] = clockHands[j].clone();
            }
            int count = 0;
            a = i;
            for (int j = 0; j < N; j++) {
                cnt = a % 4;
                a /= 4;
                rotate(copyArr, 0, j, cnt);
                count += cnt;
            }
            for (int row = 1; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    cnt = (4 - copyArr[row - 1][col]) % 4;
                    rotate(copyArr, row, col, cnt);
                    count += cnt;
                }
            }
            if (Arrays.equals(copyArr[N - 1], new int[N])) {
                answer = Math.min(answer, count);
            }
        }
        return answer;
    }

    private void rotate(int[][] arr, int row, int col, int cnt) {
        arr[row][col] = (arr[row][col] + cnt) % 4;
        if (row > 0) arr[row - 1][col] = (arr[row - 1][col] + cnt) % 4;
        if (col > 0) arr[row][col - 1] = (arr[row][col - 1] + cnt) % 4;
        if (row < arr.length - 1) arr[row + 1][col] = (arr[row + 1][col] + cnt) % 4;
        if (col < arr[0].length - 1) arr[row][col + 1] = (arr[row][col + 1] + cnt) % 4;
    }
}
