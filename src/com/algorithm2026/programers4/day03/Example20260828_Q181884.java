package com.algorithm2026.programers4.day03;

public class Example20260824_Q181884 { //n보다 커질 때까지 더하기
    public int Example20260824_Q181884(String message) {
        int answer = 0;
        for(int i=0; i<numbers.length; i++){
            answer+=numbers[i];
            if(answer>n) break;
        }
        return answer;

    }
}
