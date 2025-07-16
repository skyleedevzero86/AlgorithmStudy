package com.algorithm2025.backjoon3.day006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Example20250716_Q68937 { // 코딩테스트 연습 월간 코드 챌린지 시즌1 트리 트리오 중간값

    static ArrayList<Integer>[] board;

    public static int[] bfs(int idx, int n) {
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(idx);
        visited[idx] = 0;

        int[] max = {0, 0, 0};

        while (!q.isEmpty()) {
            int old = q.poll();
            for (int newIdx : board[old]) {
                if (visited[newIdx] == -1) {
                    visited[newIdx] = visited[old] + 1;
                    q.offer(newIdx);

                    if (max[0] < visited[newIdx]) {
                        max[0] = visited[newIdx];
                        max[1] = newIdx;
                        max[2] = 1;
                    } else if (max[0] == visited[newIdx]) {
                        max[2]++;
                        max[1] = newIdx;
                    }
                }
            }
        }

        return max;
    }

    public static int solution(int n, int[][] edges) {
        board = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            board[i] = new ArrayList<Integer>();
        }

        int answer = 0;
        int max_value = -1;

        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            board[i].add(j);
            board[j].add(i);
        }
        int[] temp = bfs(1, n);
        int[] temp2 = bfs(temp[1], n);

        if (temp2[2] >= 2) {
            return temp2[0];
        }

        else {
            int[] temp3 = bfs(temp2[1], n);

            if (temp3[2] >= 2) {
                return temp3[0];
            }

            else {
                return temp3[0]-1;
            }
        }
    }

}
