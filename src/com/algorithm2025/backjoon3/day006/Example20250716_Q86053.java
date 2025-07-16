package com.algorithm2025.backjoon3.day006;

public class Example20250716_Q86053 {

    public long Example20250716_Q86053(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = Long.MAX_VALUE;
        long start = 0;
        long end = 4 * (long)Math.pow(10, 14);

        while (start <= end) {
            long mid = (start + end) / 2;
            long gold = 0;
            long silver = 0;
            long add = 0;

            for (int i = 0; i < t.length; i++) {
                long nowG = g[i];
                long nowS = s[i];
                long nowW = w[i];
                long nowT = t[i];

                long moveCount = mid / (nowT * 2);
                if (mid % (nowT * 2) >= nowT) {
                    moveCount += 1;
                }

                gold += Math.min(nowG, moveCount * nowW);
                silver += Math.min(nowS, moveCount * nowW);
                add += Math.min(nowG + nowS, moveCount * nowW);
            }

            if (gold >= a && silver >= b && add >= (a + b)) {
                answer = Math.min(mid, answer);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

}
