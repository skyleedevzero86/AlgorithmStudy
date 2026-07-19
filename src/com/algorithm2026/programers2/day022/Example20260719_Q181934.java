package com.algorithm2026.programers2.day022;

public class Example20260719_Q181934 { //조건 문자열
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;

        if (ineq.equals(">") && eq.equals("=") && n >= m) {
            answer = 1;
        } else if (ineq.equals("<") && eq.equals("=") && n <= m) {
            answer = 1;
        } else if (ineq.equals(">") && eq.equals("!") && n > m) {
            answer = 1;
        } else if (ineq.equals("<") && eq.equals("!") && n < m) {
            answer = 1;
        }

        return answer;
    }
}
