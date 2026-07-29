package com.algorithm2026.programers2.day030;

public class Example20260729_Q181840 { //정수 찾기
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]==n){
                answer=1;
            }
        }
        return answer;
    }
}
