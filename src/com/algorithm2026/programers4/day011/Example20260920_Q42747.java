package com.algorithm2026.programers4.day011;

public class Example20260916_Q140107{ //H-index
    public int Example20260916_Q140107(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int remaining = n - i;
            if (citations[i] >= remaining) {
                return remaining;
            }
        }
        return 0;
    }
}