package com.algorithm2026.programers.day004;

public class Example20260116_Q1 { //2017 카카오코드 예선 4단 고음

    public static int treble(int n, int plusCnt) {
        int result = 0;

        // log(n)/log(3) = *의 개수
        if (n < 1 || 2 * Math.log(n) / Math.log(3) < plusCnt) {
            return 0;
        }

        // 마지막은 음높이3이고 ++이어야함
        if (n == 3 && plusCnt == 2) {
            return 1;
        }

        // *++ 충족되면 바로바로 없애
        if (n % 3 == 0 && plusCnt >= 2) {
            result += treble(n / 3, plusCnt - 2);
        }

        result += treble(n - 1, plusCnt + 1);

        return result;
    }

    public static int Example20260116_Q1(int n) {
        return treble(n-2, 2);
    }

}
