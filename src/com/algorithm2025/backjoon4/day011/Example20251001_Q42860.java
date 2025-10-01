package com.algorithm2025.backjoon4.day011;

public class Example20251001_Q42860 { //코딩테스트 연습 탐욕법(Greedy) 조이스틱

    public int Example20251001_Q42860(String name) {
        int answer = 0;
        int length = name.length();
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            int move = Math.min(c - 'A', 'Z' - c + 1); // 상하 이동 횟수 계산
            answer += move;

            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            minMove = Math.min(minMove, i + length - next + Math.min(i, length - next)); // 좌우 이동 횟수 계산
        }

        answer += minMove;
        return answer;
    }
}
