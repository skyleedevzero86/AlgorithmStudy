package com.algorithm2026.programers4.day010;

public class Example20260916_Q140107{ //점 찍기
    public long solution(int k, int d) {
        long answer = 0;
        long maxDistSq = (long) d * d;
        long step = k;
        for (long x = 0; x <= d; x += step) {
            long maxY = floorSqrt(maxDistSq - x * x);
            answer += maxY / step + 1;
        }
        return answer;
    }

    private long floorSqrt(long n) {
        long root = (long) Math.sqrt(n);
        while (root > 0 && root * root > n) {
            root--;
        }
        while ((root + 1) * (root + 1) <= n) {
            root++;
        }
        return root;
    }
}