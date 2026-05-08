package com.algorithm2026.programers2.day005;

public class Example20260508_Q468381 { // 2025 카카오 하반기 2차 기차선로
    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};
    int n, m;
    int[][] grid;
    int[] crossUsed;
    Set<Long> stateSet;
    int fixedMask;
    int visitedMask;

    boolean canEnter(int t, int dir) {
        if (t == 1) return dir == 1 || dir == 3;
        if (t == 2) return dir == 0 || dir == 2;
        if (t == 3) return true;
        if (t == 4) return dir == 0 || dir == 1;
        if (t == 5) return dir == 0 || dir == 3;
        if (t == 6) return dir == 1 || dir == 2;
        if (t == 7) return dir == 3 || dir == 2;
        return false;
    }

    int exitDir(int t, int dir) {
        if (t == 1) return dir == 3 ? 1 : (dir == 1 ? 3 : -1);
        if (t == 2) return dir == 0 ? 2 : (dir == 2 ? 0 : -1);
        if (t == 3) {
            if (dir == 3) return 1;
            if (dir == 1) return 3;
            if (dir == 0) return 2;
            if (dir == 2) return 0;
        }
        if (t == 4) return dir == 0 ? 1 : (dir == 1 ? 0 : -1);
        if (t == 5) return dir == 0 ? 3 : (dir == 3 ? 0 : -1);
        if (t == 6) return dir == 1 ? 2 : (dir == 2 ? 1 : -1);
        if (t == 7) return dir == 3 ? 2 : (dir == 2 ? 3 : -1);
        return -1;
    }

    boolean validateEnd() {
        if ((visitedMask & fixedMask) != fixedMask) return false;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 3) {
                    int id = i * m + j;
                    if (crossUsed[id] != 3) return false;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + DR[d], nc = j + DC[d];
                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) return false;
                        if (grid[nr][nc] <= 0) return false;
                        if (!canEnter(grid[nr][nc], (d + 2) % 4)) return false;
                    }
                }
            }
        return true;
    }

    int walk(int r, int c, int en) {
        if (r < 0 || r >= n || c < 0 || c >= m) return 0;
        if (grid[r][c] == -1) return 0;
        long key = ((long) r * m + c) * 4 + en;
        if (stateSet.contains(key)) return 0;
        int t = grid[r][c];
        int total = 0;
        if (t == 0) {
            for (int try_t = 1; try_t <= 7; try_t++) {
                if (!canEnter(try_t, en)) continue;
                grid[r][c] = try_t;
                total += walkRail(r, c, en);
                grid[r][c] = 0;
            }
        } else {
            if (!canEnter(t, en)) return 0;
            total = walkRail(r, c, en);
        }
        return total;
    }

    int walkRail(int r, int c, int en) {
        int t = grid[r][c];
        long key = ((long) r * m + c) * 4 + en;
        stateSet.add(key);
        int prevMask = visitedMask;
        visitedMask |= (1 << (r * m + c));
        int id = r * m + c;
        int prevCross = crossUsed[id];
        if (t == 3) {
            if (en == 1 || en == 3) crossUsed[id] |= 1;
            else crossUsed[id] |= 2;
        }
        int result;
        if (r == n - 1 && c == m - 1) {
            result = validateEnd() ? 1 : 0;
        } else {
            int outD = exitDir(t, en);
            if (outD == -1) result = 0;
            else {
                int nr = r + DR[outD];
                int nc = c + DC[outD];
                int nextEn = (outD + 2) % 4;
                result = walk(nr, nc, nextEn);
            }
        }
        crossUsed[id] = prevCross;
        visitedMask = prevMask;
        stateSet.remove(key);
        return result;
    }

    public int solution(int[][] grid_in) {
        n = grid_in.length;
        m = grid_in[0].length;
        grid = new int[n][m];
        for (int i = 0; i < n; i++) grid[i] = grid_in[i].clone();
        crossUsed = new int[n * m];
        stateSet = new HashSet<>();
        fixedMask = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] > 0) fixedMask |= (1 << (i * m + j));
        visitedMask = 1;
        if (m < 2 || grid[0][1] == -1) return 0;
        return walk(0, 1, 3);
    }
}
