package com.algorithm2026.programers2.day032;

public class Example20260731_Q181879 { // 길이에 따른 연산

    public int solution(int[] num_list) {
        int answer = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list.length > 10) {
                answer += num_list[i];
            } else if (num_list.length < 10) {
                answer = 1;
                answer *= num_list[i];
            }
        }
        return answer;
    }
}