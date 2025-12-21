package com.algorithm2025.backjoon5.zero.day00;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Example00_20251221 { //숫자 야구를 플레이하는 프로그램
    static class Query {
        int guess;
        String hint;
        Query(int g, String h) {
            guess = g;
            hint = h;
        }
    }

    public int solution(int n, Function<Integer, String> submit) {

        // 전체 가능한 숫자 공간 (1~9, 중복 없음)
        List<Integer> all = new ArrayList<>(3024);
        for (int a = 1; a <= 9; a++)
            for (int b = 1; b <= 9; b++) if (b != a)
                for (int c = 1; c <= 9; c++) if (c != a && c != b)
                    for (int d = 1; d <= 9; d++) if (d != a && d != b && d != c)
                        all.add(a * 1000 + b * 100 + c * 10 + d);

        List<Query> history = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>(all);

        int calls = 0;

        while (!candidates.isEmpty()) {

            int guess;

            if (candidates.size() == 1) {
                guess = candidates.get(0);
            } else {
                int bestGuess = all.get(0);
                int bestScore = Integer.MAX_VALUE;

                for (int g : all) {
                    Map<String, Integer> bucket = new HashMap<>();
                    int worst = 0;

                    for (int s : candidates) {
                        String h = getHint(g, s);
                        int cnt = bucket.getOrDefault(h, 0) + 1;
                        bucket.put(h, cnt);
                        worst = Math.max(worst, cnt);
                        if (worst >= bestScore) break;
                    }

                    if (worst < bestScore) {
                        bestScore = worst;
                        bestGuess = g;
                    }
                }
                guess = bestGuess;
            }

            if (calls >= n) return 0;

            String hint = submit.apply(guess);
            calls++;

            if ("4S 0B".equals(hint)) return guess;

            history.add(new Query(guess, hint));

            List<Integer> next = new ArrayList<>();
            for (int cand : candidates) {
                boolean ok = true;
                for (Query q : history) {
                    if (!getHint(q.guess, cand).equals(q.hint)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) next.add(cand);
            }
            candidates = next;
        }

        return 0;
    }

    private static String getHint(int guess, int secret) {
        int[] g = new int[4];
        int[] s = new int[4];

        for (int i = 3; i >= 0; i--) {
            g[i] = guess % 10;
            s[i] = secret % 10;
            guess /= 10;
            secret /= 10;
        }

        int strike = 0, common = 0;
        for (int i = 0; i < 4; i++) {
            if (g[i] == s[i]) strike++;
            for (int j = 0; j < 4; j++) {
                if (g[i] == s[j]) {
                    common++;
                    break;
                }
            }
        }
        return strike + "S " + (common - strike) + "B";
    }
}
