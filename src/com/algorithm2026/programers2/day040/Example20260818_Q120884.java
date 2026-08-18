package com.algorithm2026.programers2.day040;

public class Example20260818_Q120884 { //치킨 쿠폰

    public int Example20260818_Q120884(int chicken) {
        int answer = -1;
        answer=chicken/9;
        if(chicken>1&&chicken%9==0) {
            answer--;
        }
        return answer;
    }
}
