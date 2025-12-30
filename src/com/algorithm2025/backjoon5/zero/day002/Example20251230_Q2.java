package com.algorithm2025.backjoon5.zero.day002;

import java.util.*;

public class Example20251230_Q2 { //코딩테스트 연습 2023 KAKAO BLIND RECRUITMENT 1,2,3 떨어트리기

    static class Node {
        int numberOfCards = 0;
        Queue<Integer> childNode = new LinkedList<>();
        Queue<Integer> orderOfCards = new LinkedList<>();
    }

    static Queue<Integer> getCardSequence(int target, int numberOfCards) {
        Queue<Integer> ret = new LinkedList<>();

        while (numberOfCards-- > 0) {
            for (int number : new int[] {1, 2, 3}) {
                if (target - number > numberOfCards * 3)
                    continue;
                else if (target - number < numberOfCards)
                    continue;

                ret.offer(number);
                target -= number;
                break;
            }
        }

        return ret;
    }

    static int dfs(int v, List<Node> nodes) {
        if (nodes.get(v).childNode.isEmpty()) {
            nodes.get(v).numberOfCards++;
            return v;
        }
        int n = nodes.get(v).childNode.peek();
        nodes.get(v).childNode.offer(n);
        nodes.get(v).childNode.poll();

        return dfs(n, nodes);
    }

    public static int[] Example20251230_Q2(int[][] edges, int[] target) {
        int n = target.length + 1;
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            temp.add(new ArrayList<>());
            nodes.add(new Node());
        }

        for (int[] edge : edges) {
            int par = edge[0];
            int chi = edge[1];

            temp.get(par).add(chi);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(temp.get(i));
            for (int j : temp.get(i)) {
                nodes.get(i).childNode.offer(j);
            }
        }

        boolean flag = true;
        while (flag) {
            int leafNode = dfs(1, nodes);
            result.add(leafNode);
            if (target[leafNode - 1] < nodes.get(leafNode).numberOfCards) {
                return new int[] {-1};
            }

            flag = false;
            for (int i = 1; i < n; i++) {
                if (target[i - 1] > nodes.get(i).numberOfCards * 3) {
                    flag = true;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            nodes.get(i).orderOfCards = getCardSequence(target[i - 1], nodes.get(i).numberOfCards);
        }

        answer = new int[result.size()];
        int idx = 0;
        for (int i : result) {
            int t = nodes.get(i).orderOfCards.peek();
            nodes.get(i).orderOfCards.poll();
            answer[idx++] = t;
        }

        return answer;
    }

}
