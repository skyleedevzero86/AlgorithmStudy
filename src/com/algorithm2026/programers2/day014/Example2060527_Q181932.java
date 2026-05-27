package com.algorithm2026.programers2.day014;

public class Example2060527_Q181932 { // 코딩테스트 연습 코딩 기초 트레이닝 코드 처리하기
    public String Example2060527_Q181932(String code) {
        String answer = "";
        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1')
                mode = 1 - mode;
            else if (i % 2 == mode)
                answer += code.charAt(i);
        }

        return answer.isEmpty() ? "EMPTY" : answer;
    }
}
