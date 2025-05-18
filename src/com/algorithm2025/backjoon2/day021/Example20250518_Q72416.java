package com.algorithm2025.backjoon2.day021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20250518_Q72416 { //코딩테스트 연습 2021 KAKAO BLIND RECRUITMENT 매출 하락 최소화

    static Map<Integer, List<Integer>> team = new HashMap<>();

    // Pair 클래스를 직접 만듭니다.
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // dfs 메소드
    static Pair dfs(List<Integer> sales, int member) {
        if(!team.containsKey(member)) { // leaf node
            return new Pair(0, sales.get(member-1)); // first:0, second:나의 하루평균 매출액
        }
        else {
            int sum = 0, min_diff = 1_000_000_000;
            boolean flag = false;

            for(int mem : team.get(member)) {
                Pair res = dfs(sales, mem);


                sum += Math.min(res.first, res.second);


                if(res.first >= res.second) flag = true;


                min_diff = Math.min(min_diff, res.second - res.first);
            }

            if(flag) return new Pair(sum, sales.get(member-1) + sum);
            else return new Pair(sum + min_diff, sales.get(member-1) + sum);
        }
    }

    public static int Example20250518_Q72416(int[] sales, int[][] links) {
        int answer = 0;
        List<Integer> salesList = new ArrayList<>();
        for(int i = 0; i < sales.length; i++) {
            salesList.add(sales[i]);
        }

        for(int[] link : links) {
            int from = link[0];
            int to = link[1];
            if(!team.containsKey(from)) {
                team.put(from, new ArrayList<>());
            }
            team.get(from).add(to);
        }

        Pair res = dfs(salesList, 1);
        answer = Math.min(res.first, res.second);
        return answer;
    }
}
