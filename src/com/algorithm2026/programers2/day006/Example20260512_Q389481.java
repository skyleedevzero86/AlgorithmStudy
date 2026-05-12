package com.algorithm2026.programers2.day006;

import java.util.*;

public class Example20260512_Q389481 { //2025 프로그래머스 코드챌린지 2차 예선 봉인된 주문

    private Set<String> bannedSet;
    private long[] countByLength;

    public String solution(long n, String[] bans) {
        bannedSet = new HashSet<>();
        for (String ban : bans) {
            bannedSet.add(ban);
        }

        countByLength = new long[12];
        countByLength[1] = 26;
        for (int len = 2; len <= 11; len++) {
            countByLength[len] = countByLength[len - 1] * 26;
        }

        return findNthString(n);
    }

    private String findNthString(long n) {
        long remaining = n;
        StringBuilder result = new StringBuilder();

        for (int len = 1; len <= 11; len++) {
            long totalCount = countByLength[len];
            long bannedCount = 0;
            for (String ban : bannedSet) {
                if (ban.length() == len) {
                    bannedCount++;
                }
            }
            long validCount = totalCount - bannedCount;

            if (validCount >= remaining) {
                return findStringAtLength(len, remaining);
            } else {
                remaining -= validCount;
            }
        }

        return "";
    }

    private String findStringAtLength(int len, long remaining) {
        StringBuilder result = new StringBuilder();
        return dfsBuildString(len, remaining, result);
    }

    private String dfsBuildString(int len, long remaining, StringBuilder current) {

        if (current.length() == len) {
            if (bannedSet.contains(current.toString())) {
                return null;
            }

            if (remaining == 1) {
                return current.toString();
            }
            return null;
        }

        long currentRemaining = remaining;
        for (char c = 'a'; c <= 'z'; c++) {
            current.append(c);
            // 지금까지 만든 접두사로 시작하는 문자열 개수 계산
            long count = countStringsWithPrefix(current.toString(), len);
            // 삭제된 문자열 제외
            long bannedCount = 0;
            for (String ban : bannedSet) {
                if (ban.length() == len && ban.startsWith(current.toString())) {
                    bannedCount++;
                }
            }
            long validCount = count - bannedCount;

            if (validCount >= currentRemaining) {
                // 현재 접두사로 진행 가능
                String result = dfsBuildString(len, currentRemaining, current);
                if (result != null) {
                    return result;
                }
            }

            currentRemaining -= validCount;
            if (currentRemaining <= 0) {
                break;
            }
            current.setLength(current.length() - 1);
        }

        return null;
    }

    private long countStringsWithPrefix(String prefix, int len) {
        int remainingLength = len - prefix.length();
        if (remainingLength <= 0) {
            return 1;
        }
        return countByLength[remainingLength];
    }

}
