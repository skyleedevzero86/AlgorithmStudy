package com.algorithm2026.programers2.day020;

public class Example20260709_Q181933 { //조건 문자열
    public int Example20260709_Q181933(String ineq, String eq, int n, int m) {
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
