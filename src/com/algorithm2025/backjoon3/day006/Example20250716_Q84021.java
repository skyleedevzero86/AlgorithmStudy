package com.algorithm2025.backjoon3.day006;

import java.util.*;

public class Example20250716_Q84021 { //코딩테스트 연습 깊이/너비 우선 탐색(DFS/BFS)  퍼즐 조각 채우기

    List<List<Point>> t = new ArrayList<>();
    List<List<Point>> g = new ArrayList<>();
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int Example20250716_Q84021(int[][] game_board, int[][] table) {
        int answer = 0;

        int len = game_board.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                game_board[i][j] = game_board[i][j] == 0 ? 1 : 0;
            }
        }

        boolean[][] visited_t = new boolean[len][len];
        boolean[][] visited_g = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (table[i][j] == 1 && !visited_t[i][j])
                    bfs(i, j, table, visited_t, t);

                if (game_board[i][j] == 1 && !visited_g[i][j])
                    bfs(i, j, game_board, visited_g, g);
            }
        }

        answer = compareBlock(t, g, answer);

        return answer;
    }

    public int compareBlock(List<List<Point>> table, List<List<Point>> board, int answer) {
        int table_size = table.size();
        int board_size = board.size();

        boolean[] visited = new boolean[board_size];

        for (int i = 0; i < table_size; i++) {
            for (int j = 0; j < board_size; j++) {
                // 일치하면
                if (visited[j] || table.get(i).size() != board.get(j).size())
                    continue;
                if (isRotate(table.get(i), board.get(j))) {
                    visited[j] = true; // 블록으로 채워짐
                    answer += board.get(j).size();
                    break;
                }
            }
        }

        return answer;
    }

    public boolean isRotate(List<Point> table, List<Point> board) {

        Collections.sort(board);

        for (int i = 0; i < 4; i++) {

            Collections.sort(table);

            int curr_x = table.get(0).x;
            int curr_y = table.get(0).y;

            for (int j = 0; j < table.size(); j++) {
                table.get(j).x -= curr_x;
                table.get(j).y -= curr_y;
            }

            boolean check = true;

            for (int j = 0; j < board.size(); j++) {
                if (board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y) {
                    check = false;
                    break;
                }
            }

            if (check) {
                return true;
            } else {

                for (int j = 0; j < table.size(); j++) {
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }

        return false;
    }

    public void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> list) {
        visited[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        List<Point> sub_list = new ArrayList<>();
        sub_list.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length)
                    continue;

                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    sub_list.add(new Point(nx - x, ny - y));
                }
            }
        }

        list.add(sub_list);
    }

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o) {
            int res = Integer.compare(this.x, o.x);
            if (res == 0) {
                res = Integer.compare(this.y, o.y);
            }
            return res;
        }
    }
}
