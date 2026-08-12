package com.algorithm2026.programers2.day039;

public class Example20260812_Q181831 { //특별한 2차원배열 2

    public int solution(int[][] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }

        return 1;
    }
}
