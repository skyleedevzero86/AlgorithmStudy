package com.algorithm2025.backjoon3.day002;

import java.util.Arrays;

public class Example20250621_Q1051 {  //1051. Height Checker

    public int heightChecker(int[] heights) {

        int[] expectedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expectedHeights);

        int mismatchCount = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expectedHeights[i]) {
                mismatchCount++;
            }
        }

        return mismatchCount;
    }

}