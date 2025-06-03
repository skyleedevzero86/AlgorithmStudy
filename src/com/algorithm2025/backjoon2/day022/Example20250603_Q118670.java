package com.algorithm2025.backjoon2.day022;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example20250603_Q118670 { //코딩테스트 연습 2022 KAKAO TECH INTERNSHIP 행렬과 연산
    private int r, c;
    private ArrayDeque<Integer> col1, col2;
    private LinkedList<ArrayDeque<Integer>> rows;

    private void init(int[][] rc) {
        r = rc.length;
        c = rc[0].length;

        col1 = IntStream.range(0, r)
                .mapToObj(i -> rc[i][0])
                .collect(Collectors.toCollection(ArrayDeque::new));

        col2 = IntStream.range(0, r)
                .mapToObj(i -> rc[i][c - 1])
                .collect(Collectors.toCollection(ArrayDeque::new));

        rows = IntStream.range(0, r)
                .mapToObj(i -> IntStream.range(1, c - 1)
                        .mapToObj(j -> rc[i][j])
                        .collect(Collectors.toCollection(ArrayDeque::new)))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private int[][] getAnswer() {
        int[][] ans = new int[r][c];

        IntStream.range(0, r).forEach(i -> {
            ans[i][0] = col1.pollFirst();
            ans[i][c - 1] = col2.pollFirst();
        });

        IntStream.range(0, r).forEach(i -> {
            ArrayDeque<Integer> row = rows.pollFirst();
            IntStream.range(1, c - 1).forEach(j -> ans[i][j] = row.pollFirst());
        });

        return ans;
    }

    private void rotate() {
        if (c == 2) {
            col2.addFirst(col1.pollFirst());
            col1.addLast(col2.pollLast());
            return;
        }

        rows.peekFirst().addFirst(col1.pollFirst());
        col2.addFirst(rows.peekFirst().pollLast());
        rows.peekLast().addLast(col2.pollLast());
        col1.addLast(rows.peekLast().pollFirst());
    }

    private void shiftRow() {
        rows.addFirst(rows.pollLast());
        col1.addFirst(col1.pollLast());
        col2.addFirst(col2.pollLast());
    }

    public int[][] Example20250603_Q118670(int[][] rc, String[] operations) {
        init(rc);

        Arrays.stream(operations)
                .map(op -> (Runnable) (() -> {
                    if (op.equals("Rotate")) rotate();
                    else if (op.equals("ShiftRow")) shiftRow();
                }))
                .forEach(Runnable::run);

        return getAnswer();
    }
}
