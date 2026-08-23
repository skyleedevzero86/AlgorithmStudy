package com.algorithm2026.programers4.day01;

public class Example20260823_Q120898 { //편지
    public int Example20260823_Q120898(String message) {
        int answer = 0;
        if(message.length()>=1&&message.length()<=50) {
            char ch[]=message.toCharArray();
            answer = ch.length*2;
        }
        return answer;
    }
}
