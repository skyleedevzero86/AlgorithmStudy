package com.algorithm2026.programers.day016;

public class Example20260204_Q1 { //코딩테스트 연습  Summer/Winter Coding(~2018)  쿠키 구입
    public int Example20260204_Q1(int[] cookie) {
        int answer = 0;
        int n = cookie.length;

        for (int i = 0; i < n - 1; i++) {
            int left_sum = cookie[i], left_idx = i;
            int right_sum = cookie[i + 1], right_idx = i + 1;

            while (true) {
                if (left_sum == right_sum) {
                    answer = Math.max(answer, left_sum);
                    // answer = Math.max(answer, right_sum);
                }

                if (left_idx > 0 && left_sum <= right_sum) {
                    left_idx -= 1;
                    left_sum += cookie[left_idx];
                } else if (right_idx < n - 1 && right_sum <= left_sum) {
                    right_idx += 1;
                    right_sum += cookie[right_idx];
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
