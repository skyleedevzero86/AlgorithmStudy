package com.algorithm2026.programers2.day036;

public class Example20260805_Q181935 { // 홀짝에 따라 다른 값 반환하기
    public int solution(int n) {
        int answer = 0;
        if (n % 2 == 1) {
            for (int i = 1; i <= n; i += 2) {
                answer += i;
            }
        } else {
            for (int i = 2; i <= n; i += 2) {
                answer += (i * i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Example20260805_Q181935 sol = new Example20260805_Q181935();
        System.out.println(sol.solution(7));
        System.out.println(sol.solution(10));
    }
}
