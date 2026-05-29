package com.algorithm2026.programers2.day016;

public class Example20260529_Q181936 { //공배수

    public int solution(int number, int n, int m) {
        int answer = 0;
        if(number%n==0&&number%m==0){
            answer=1;
        } else if(number%m==0&&number%n!=0){
            answer=0;
        }
        return answer;
    }
}
