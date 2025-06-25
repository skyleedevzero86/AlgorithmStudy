package com.algorithm2025.backjoon3.day003;

public class Example20250625_Q_LC896 { //896. Monotonic Array

    public boolean isMonotonic(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {
                isIncreasing = false;
            }

            if (nums[i] > nums[i - 1]) {
                isDecreasing = false;
            }


            if (!isIncreasing && !isDecreasing) {
                return false;
            }
        }

        return isIncreasing || isDecreasing;
    }

}