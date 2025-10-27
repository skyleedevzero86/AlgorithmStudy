package com.algorithm2025.backjoon4.day018;

import java.util.HashMap;
import java.util.Map;

public class Example20251027_Q17685 { // 코딩테스트 연습 2018 KAKAO BLIND RECRUITMENT [3차] 자동완성

    public int solution(String[] words) {
        int answer = 0;
        Trie word_dict = new Trie();
        for (String word : words) {
            word_dict.insert(word);
        }
        for (String word : words) {
            answer += word_dict.search(word);
        }
        return answer;
    }
}

class Trie {
    private Map<Character, Trie> child;
    private int count;

    public Trie() {
        child = new HashMap<>();
        count = 0;
    }

    public void insert(String string) {
        Trie curr = this;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!curr.child.containsKey(c)) {
                curr.child.put(c, new Trie());
            }
            curr = curr.child.get(c);
            curr.count++;
        }
    }

    public int search(String string) {
        Trie curr = this;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (curr.child.get(c).count == 1) {
                return i + 1;
            }
            curr = curr.child.get(c);
        }
        return string.length();
    }
}