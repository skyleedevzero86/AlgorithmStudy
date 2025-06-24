package com.algorithm2025.backjoon3.day002;

import java.util.*;

public class Example20250621_Q84021 { //코딩테스트 연습 깊이/너비 우선 탐색(DFS/BFS)  퍼즐 조각 채우기 복습

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int Example20250621_Q84021(int[][] game_board, int[][] table) {
        int len = game_board.length;
        List<List<Point>> emptySpaces = extractBlocks(game_board, 0, true);
        List<List<Point>> tableBlocks = extractBlocks(table, 1, false);

        boolean[] used = new boolean[emptySpaces.size()];
        int answer = 0;

        for (List<Point> block : tableBlocks) {
            normalize(block);
            for (int i = 0; i < emptySpaces.size(); i++) {
                if (used[i] || block.size() != emptySpaces.get(i).size()) continue;
                if (canFit(block, emptySpaces.get(i))) {
                    used[i] = true;
                    answer += block.size();
                    break;
                }
            }
        }

        return answer;
    }

    private List<List<Point>> extractBlocks(int[][] board, int target, boolean invert) {
        int len = board.length;
        boolean[][] visited = new boolean[len][len];
        List<List<Point>> blocks = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int value = invert ? 1 - board[i][j] : board[i][j];
                if (value == target && !visited[i][j]) {
                    blocks.add(bfs(i, j, board, visited, target, invert));
                }
            }
        }
        return blocks;
    }

    private List<Point> bfs(int x, int y, int[][] board, boolean[][] visited, int target, boolean invert) {
        Queue<Point> q = new LinkedList<>();
        List<Point> shape = new ArrayList<>();

        q.add(new Point(x, y));
        visited[x][y] = true;
        shape.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length && !visited[nx][ny]) {
                    int value = invert ? 1 - board[nx][ny] : board[nx][ny];
                    if (value == target) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                        shape.add(new Point(nx - x, ny - y));
                    }
                }
            }
        }
        return shape;
    }

    private boolean canFit(List<Point> block, List<Point> space) {
        for (int i = 0; i < 4; i++) {
            normalize(block);
            if (match(block, space)) return true;
            rotate(block);
        }
        return false;
    }

    private void rotate(List<Point> shape) {
        for (Point p : shape) {
            int temp = p.x;
            p.x = p.y;
            p.y = -temp;
        }
    }

    private void normalize(List<Point> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Point p : shape) {
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }
        for (Point p : shape) {
            p.x -= minX;
            p.y -= minY;
        }
        Collections.sort(shape);
    }

    private boolean match(List<Point> a, List<Point> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).x != b.get(i).x || a.get(i).y != b.get(i).y) return false;
        }
        return true;
    }

    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o) {
            return x != o.x ? Integer.compare(x, o.x) : Integer.compare(y, o.y);
        }
    }

}
