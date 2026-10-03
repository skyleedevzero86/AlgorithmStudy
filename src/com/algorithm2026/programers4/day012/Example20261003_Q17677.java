package com.algorithm2026.programers4.day012;

import java.util.HashMap;
import java.util.Map;

public class Example20261003_Q17677{ // [1차] 뉴스 클러스터링
    private static final int SCALE = 65536;

    public int Example20261003_Q17677(String str1, String str2) {
        Map<String, Integer> a = toMultiset(str1);
        Map<String, Integer> b = toMultiset(str2);

        int intersection = 0;
        int union = 0;

        for (Map.Entry<String, Integer> e : a.entrySet()) {
            int countB = b.getOrDefault(e.getKey(), 0);
            intersection += Math.min(e.getValue(), countB);
            union += Math.max(e.getValue(), countB);
        }
        for (Map.Entry<String, Integer> e : b.entrySet()) {
            if (!a.containsKey(e.getKey())) {
                union += e.getValue();
            }
        }

        if (union == 0) {
            return SCALE;
        }
        return (int) ((long) intersection * SCALE / union);
    }

    static Map<String, Integer> toMultiset(String s) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (isAsciiLetter(c1) && isAsciiLetter(c2)) {
                String key = "" + Character.toLowerCase(c1) + Character.toLowerCase(c2);
                counts.merge(key, 1, Integer::sum);
            }
        }
        return counts;
    }

    private static boolean isAsciiLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}