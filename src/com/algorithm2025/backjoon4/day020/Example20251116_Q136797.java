package com.algorithm2025.backjoon4.day020;

import java.util.Arrays;

public class Example20251116_Q136797 { //  숫자 타자 대회

    private static final int MAX = 100001;
    private static final int NUMBER_MAX = 10;

    private static final int[][] steps = new int[][]{
            {1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
            {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
            {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
            {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
            {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
            {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
            {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
            {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
            {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
            {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}
    };

    private static int[][][] cache = new int[MAX][NUMBER_MAX][NUMBER_MAX];

    private static String copyNumbers;

    private static int func(int idx, int left, int right) {
        if (idx == copyNumbers.length()) {
            return 0;
        }

        int cur = copyNumbers.charAt(idx) - '0';
        int[] fingerPos = new int[]{left, right};
        int result = cache[idx][left][right];

        if (result != -1) {
            return result;
        }

        if (left == cur || right == cur) {
            result = 1 + func(idx + 1, left, right);
        } else {

            result = Math.min(
                    func(idx + 1, cur, right) + steps[fingerPos[0]][cur],
                    func(idx + 1, left, cur) + steps[fingerPos[1]][cur]
            );
        }

        return cache[idx][left][right] = result;
    }

    public static int solution(String numbers) {
        for (int[][] arr2D : cache) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        copyNumbers = numbers;
        return func(0, 4, 6);
    }

}
