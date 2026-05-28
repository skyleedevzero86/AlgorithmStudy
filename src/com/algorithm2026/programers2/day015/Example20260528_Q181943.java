package com.algorithm2026.programers2.day015;

public class Example20260528_Q181943 {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String StartTitle=my_string.substring(0,s);
        String EndTitle=my_string.substring(overwrite_string.length()+s);
        answer=StartTitle+overwrite_string+EndTitle;
        return answer;
    }
}
