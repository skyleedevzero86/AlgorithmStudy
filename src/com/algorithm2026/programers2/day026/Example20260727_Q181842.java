package com.algorithm2026.programers2.day026;

public class Example20260727_Q181842 { //부분문자열
    public int solution(String str1, String str2) {
        int answer = 0;
        if(str2.contains(str1)){
            answer = 1;
        }
        return answer;
    }
}
