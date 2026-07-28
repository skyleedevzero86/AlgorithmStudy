package com.algorithm2026.programers2.day029;

public class Example20260728_Q181841 { //프로그래머스 꼬리문자열
    public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();
        for (String str : str_list) {
            if (!str.contains(ex)) {
                answer.append(str);
            }
        }
        return answer.toString();
    }
}
