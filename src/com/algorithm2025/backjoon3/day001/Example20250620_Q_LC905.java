package com.algorithm2025.backjoon3.day001;

import java.util.ArrayList;
import java.util.List;

public class Example20250620_Q_LC905 { //번외 Leetcode 905 Sort Array By Parity

    public int[] sortArrayByparity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        int[] ans = new int[nums.length];
        int index = 0;

        for (int e : even) {
            ans[index++] = e;
        }

        for (int o : odd) {
            ans[index++] = o;
        }

        return ans;
    }

}
