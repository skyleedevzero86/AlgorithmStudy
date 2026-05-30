package com.algorithm2026.programers2.day018;

import java.util.*;

public class Example20260530_Q169199 { //연습문제 리코쳇 로봇

    static int n;
    static int m;
    static char[][] map;
    static int[] start;
    static int[] dest;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;

    static class Node {
        int row;
        int col;
        int val;

        public Node(final int row, final int col, final int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int solution(String[] board) {
        int answer = 0;
        boolean goal = false;

        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        start = new int[2];
        dest = new int[2];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);

                if (map[i][j] == 'R') {
                    start = new int[]{i, j};
                } else if (map[i][j] == 'G') {
                    dest = new int[]{i, j};
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.row == dest[0] && now.col == dest[1]) {
                goal = true;
                answer = now.val;
                break;
            }

            for (int[] p : pos) {
                int nr = now.row;
                int nc = now.col;

                while (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 'D') {
                    nr += p[0];
                    nc += p[1];
                }

                nr -= p[0];
                nc -= p[1];

                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new Node(nr, nc, now.val + 1));
            }

        }

        if (goal) {
            return answer;
        }

        return -1;
    }
}
