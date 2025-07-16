package com.algorithm2025.backjoon3.day006;

public class Example20250716_Q92345 { //코딩테스트 연습 2022 KAKAO BLIND RECRUITMENT 사라지는 발판


    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int n, m;

    boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    int[][] vis = new int[5][5];
    int[][] block = new int[5][5];

    int solve(int curx, int cury, int opx, int opy) {
        if (vis[curx][cury] == 1) return 0;
        int ret = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = curx + dx[dir];
            int ny = cury + dy[dir];
            if (OOB(nx, ny) || vis[nx][ny] == 1 || block[nx][ny] == 0) continue;
            vis[curx][cury] = 1;

            int val = solve(opx, opy, nx, ny) + 1;

            vis[curx][cury] = 0;

            if (ret % 2 == 0 && val % 2 == 1) ret = val;
            else if (ret % 2 == 0 && val % 2 == 0) ret = Math.max(ret, val);
            else if (ret % 2 == 1 && val % 2 == 1) ret = Math.min(ret, val);
        }
        return ret;
    }

    public int Example20250716_Q92345(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                block[i][j] = board[i][j];
            }
        }
        return solve(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
}
