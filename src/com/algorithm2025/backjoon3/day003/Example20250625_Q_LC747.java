package com.algorithm2025.backjoon3.day003;


public class Example20250625_Q_LC747 { //747. Largest Number At Least Twice of Others

    public int dominantIndex(int[] nums) {

        if (nums.length <= 1) {
            return nums.length == 1 ? 0 : -1;
        }


        int maxVal = -1;
        int secondMaxVal = -1;
        int maxIndex = -1;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                secondMaxVal = maxVal;
                maxVal = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMaxVal) {
                secondMaxVal = nums[i];
            }
        }

        if (maxVal >= 2 * secondMaxVal) {
            return maxIndex;
        } else {
            return -1;
        }
    }
}