package com.algorithm2025.backjoon4.day003;

public class Example20250908_Q169198 { //코딩테스트 연습 연습문제  당구 연습
    public int[] Example20250908_Q169198(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int x1 = startX;
        int y1 = startY;
        for (int i = 0; i < balls.length; i++) {
            int x2 = balls[i][0];
            int y2 = balls[i][1];
            if (x1 == x2) {
                int d1 = (y2 - y1) * (y2 - y1) + 4 * x1 * x1;
                int d2 = (y2 - y1) * (y2 - y1) + 4 * (m - x1) * (m - x1);
                int d3 = y1 < y2 ? (y1 + y2) * (y1 + y2) : (2 * n - y1 - y2) * (2 * n - y1 - y2);
                answer[i] = Math.min(Math.min(d1, d2), d3);
            } else if (y1 == y2) {
                int d1 = (x2 - x1) * (x2 - x1) + 4 * y1 * y1;
                int d2 = (x2 - x1) * (x2 - x1) + 4 * (n - y1) * (n - y1);
                int d3 = x1 < x2 ? (x1 + x2) * (x1 + x2) : (2 * m - x1 - x2) * (2 * m - x1 - x2);
                answer[i] = Math.min(Math.min(d1, d2), d3);
            } else {
                int d1 = (x2 - x1) * (x2 - x1) + (y2 + y1) * (y2 + y1);
                int d2 = (x2 + x1) * (x2 + x1) + (y2 - y1) * (y2 - y1);
                int d3 = (y2 - y1) * (y2 - y1) + (2 * m - x1 - x2) * (2 * m - x1 - x2);
                int d4 = (x2 - x1) * (x2 - x1) + (2 * n - y1 - y2) * (2 * n - y1 - y2);
                answer[i] = Math.min(Math.min(d1, d2), Math.min(d3, d4));
            }
        }
        return answer;
    }
}
