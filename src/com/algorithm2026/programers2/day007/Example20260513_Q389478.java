package com.algorithm2026.programers2.day007;

public class Example20260513_Q389478 { //2025 프로그래머스 코드챌린지 2차 예선 택배 상자 꺼내기

    public int solution(int n, int w, int num) {

        int totalRows = (n + w - 1) / w;

        int numRow = (num - 1) / w;
        int numCol;
        if (numRow % 2 == 0) {

            numCol = (num - 1) % w;
        } else {

            numCol = w - 1 - (num - 1) % w;
        }


        int boxesToRemove = 0;
        for (int i = num + 1; i <= n; i++) {
            int row = (i - 1) / w;
            int col;
            if (row % 2 == 0) {
                col = (i - 1) % w;
            } else {
                col = w - 1 - (i - 1) % w;
            }

            if (col == numCol && row > numRow) {
                boxesToRemove++;
            }
        }


        return boxesToRemove + 1;
    }
}
