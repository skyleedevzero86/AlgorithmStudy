package com.algorithm2026.programers2.day004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20260505_Q60060 { //코딩테스트 연습 2020 KAKAO BLIND RECRUITMENT 가사 검색

    public int[] Example20260505_Q60060(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Map<Integer, List<String>> cands = new HashMap<>();
        Map<Integer, List<String>> reverseCands = new HashMap<>();

        // 길이별 저장
        for (String word : words) {
            int length = word.length();
            if (!cands.containsKey(length)) {
                cands.put(length, new ArrayList<>());
                reverseCands.put(length, new ArrayList<>());
            }
            cands.get(length).add(word);
            reverseCands.get(length).add(new StringBuilder(word).reverse().toString());
        }

        // 정렬 O(NlogN)
        for (List<String> cand : cands.values()) {
            cand.sort(null);
        }
        for (List<String> cand : reverseCands.values()) {
            cand.sort(null);
        }

        // 탐색 O(N*logM)
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            List<String> lst;
            String start, end;
            // 접두사
            if (query.charAt(0) == '?') {
                lst = reverseCands.get(query.length());
                if(lst == null) {
                    answer[i] = 0;
                    continue;
                }
                start = new StringBuilder(query).reverse().toString().replace('?', 'a');
                end = new StringBuilder(query).reverse().toString().replace('?', 'z');
            }
            // 접미사
            else {
                lst = cands.get(query.length());
                if(lst == null) {
                    answer[i] = 0;
                    continue;
                }
                start = query.replace('?', 'a');
                end = query.replace('?', 'z');
            }
            answer[i] = countByRange(lst, start, end);
        }

        return answer;
    }

    private int countByRange(List<String> lst, String start, String end) {
        int left = lowerBound(lst, start);
        int right = upperBound(lst, end);
        return right - left;
    }

    private int lowerBound(List<String> lst, String target) {
        int left = 0;
        int right = lst.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (lst.get(mid).compareTo(target) >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private int upperBound(List<String> lst, String target) {
        int left = 0;
        int right = lst.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (lst.get(mid).compareTo(target) > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

}
