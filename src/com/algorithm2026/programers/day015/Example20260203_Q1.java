package com.algorithm2026.programers.day015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Example20260203_Q1 { //방의 개수
    public int solution(int[] arrows) {
        int answer = 0;
        Map<Pair, List<Pair>> visit = new HashMap<>();
        int x = 0, y = 0;
        int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
        Pair start = new Pair(0, 0);
        visit.put(start, new ArrayList<>()); // 초기 위치를 visit에 추가
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[arrow];
                int ny = y + dy[arrow];
                Pair current = new Pair(x, y);
                Pair next = new Pair(nx, ny);
                if (visit.containsKey(next) && !visit.get(next).contains(current)) {
                    answer++;
                    visit.get(current).add(next);
                    visit.get(next).add(current);
                } else if (!visit.containsKey(next)) {
                    List<Pair> list = new ArrayList<>();
                    list.add(current);
                    visit.put(next, list);
                    visit.get(current).add(next);
                    visit.putIfAbsent(current, new ArrayList<>()); // 현재 위치가 visit에 없을 경우 추가
                }
                x = nx;
                y = ny;
            }
        }
        return answer;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
