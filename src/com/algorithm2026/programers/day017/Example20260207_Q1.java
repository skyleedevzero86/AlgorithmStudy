package com.algorithm2026.programers.day017;

import java.util.PriorityQueue;

public class Example20260207_Q1 { //코딩테스트 연습  Summer/Winter Coding(2019) 지형 이동
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int Example20260207_Q1(int[][] land, int height) {
        int n = land.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, 0, 0});
        int answer = 0;

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int v = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;
            answer += v;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(land[x][y] - land[nx][ny]);

                if (diff > height) {
                    heap.offer(new int[]{diff, nx, ny});
                } else {
                    heap.offer(new int[]{0, nx, ny});
                }
            }
        }

        return answer;
    }
}
