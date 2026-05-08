package com.algorithm2026.programers2.day005;

public class Example20260508_Q181880 { //기초트페이닝 1로만들기
    public int solution(int[] num_list) {
        int answer = 0;
        for (int n:num_list){
            while(n>1){
                n/=2;
                answer++;
            }
        }
        return answer;
    }
}
