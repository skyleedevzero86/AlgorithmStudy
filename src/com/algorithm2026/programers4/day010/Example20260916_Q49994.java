package com.algorithm2026.programers4.day010;

import java.util.HashSet;
import java.util.Set;

public class Example20260916_Q49994{ //방문 길이


    private static final int BOUND = 5;
    private static final int GRID = 11;

    public int solution(String dirs) {
        Set<Integer> walked = new HashSet<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int nx = x;
            int ny = y;
            char command = dirs.charAt(i);
            if (command == 'U') {
                ny += 1;
            } else if (command == 'D') {
                ny -= 1;
            } else if (command == 'R') {
                nx += 1;
            } else {
                nx -= 1;
            }
            if (nx < -BOUND || nx > BOUND || ny < -BOUND || ny > BOUND) {
                continue;
            }
            walked.add(undirectedEdge(x, y, nx, ny));
            x = nx;
            y = ny;
        }
        return walked.size();
    }

    private int undirectedEdge(int x1, int y1, int x2, int y2) {
        int from = encode(x1, y1);
        int to = encode(x2, y2);
        if (from > to) {
            int tmp = from;
            from = to;
            to = tmp;
        }
        return from * (GRID * GRID) + to;
    }

    private int encode(int x, int y) {
        return (x + BOUND) * GRID + (y + BOUND);
    }
}