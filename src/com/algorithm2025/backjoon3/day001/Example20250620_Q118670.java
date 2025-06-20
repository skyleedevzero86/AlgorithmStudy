package com.algorithm2025.backjoon3.day001;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example20250620_Q118670 { //코딩테스트 연습 2022 KAKAO TECH INTERNSHIP 행렬과 연산

    private int rowsCount, colsCount;
    // 행렬의 가장 왼쪽 열을 저장하는 Deque
    private ArrayDeque<Integer> leftCol;
    // 행렬의 가장 오른쪽 열을 저장하는 Deque
    private ArrayDeque<Integer> rightCol;
    // 행렬의 가운데 행들을 저장하는 LinkedList. 각 행은 또 다른 Deque로 표현됨.
    private LinkedList<ArrayDeque<Integer>> centerRows;

    // 초기화 메서드: 입력 행렬 rc를 세 부분(leftCol, rightCol, centerRows)으로 나눔
    private void init(int[][] rc) {
        rowsCount = rc.length; // 행 개수
        colsCount = rc[0].length; // 열 개수

        leftCol = new ArrayDeque<>();
        rightCol = new ArrayDeque<>();
        centerRows = new LinkedList<>();

        // 행렬의 각 행을 순회하면서 데이터를 분리하여 저장
        for (int i = 0; i < rowsCount; i++) {
            // 현재 행의 첫 번째 요소는 leftCol에 추가
            leftCol.addLast(rc[i][0]);
            // 현재 행의 마지막 요소는 rightCol에 추가
            rightCol.addLast(rc[i][colsCount - 1]);

            // 가운데 열들을 저장할 Deque 생성
            ArrayDeque<Integer> center = new ArrayDeque<>();
            // 현재 행의 두 번째 열부터 (colsCount - 2)번째 열까지 center에 추가
            for (int j = 1; j < colsCount - 1; j++) {
                center.addLast(rc[i][j]);
            }
            // 완성된 가운데 행 Deque를 centerRows에 추가
            centerRows.addLast(center);
        }
    }

    // 최종 결과 행렬을 생성하여 반환하는 메서드
    private int[][] getResultMatrix() {
        int[][] result = new int[rowsCount][colsCount]; // 결과 행렬 초기화
        int i = 0;
        // centerRows를 순회하면서 각 행을 원래 행렬 형태로 재조립
        for (ArrayDeque<Integer> row : centerRows) {
            // 현재 행의 첫 번째 열은 leftCol에서 가져옴
            result[i][0] = leftCol.pollFirst(); // pollFirst()는 맨 앞 요소를 꺼내고 삭제

            int j = 1;
            // 가운데 행의 요소들을 순서대로 결과 행렬에 채움
            for (int val : row) {
                result[i][j++] = val;
            }
            // 현재 행의 마지막 열은 rightCol에서 가져옴
            result[i][colsCount - 1] = rightCol.pollFirst();
            i++;
        }
        return result;
    }

    // rotate 연산: 행렬의 테두리를 시계 방향으로 한 칸씩 회전
    private void rotate() {
        // 특수 케이스: 열이 2개인 경우 (가운데 열이 없는 경우)
        if (colsCount == 2) {
            // 오른쪽 열의 맨 위 요소를 왼쪽 열의 맨 위로 이동
            rightCol.addFirst(leftCol.pollFirst());
            // 왼쪽 열의 맨 아래 요소를 오른쪽 열의 맨 아래로 이동
            leftCol.addLast(rightCol.pollLast());
            return; // 함수 종료
        }

        // 일반적인 경우: 열이 3개 이상인 경우

        // 1. 왼쪽 위 (leftCol의 맨 위) → 가운데 첫 번째 행의 맨 앞
        // leftCol의 맨 위 요소를 꺼내서 (pollFirst)
        // centerRows의 첫 번째 행 (peekFirst())의 맨 앞에 추가 (addFirst)
        centerRows.peekFirst().addFirst(leftCol.pollFirst());

        // 2. 가운데 첫 번째 행의 맨 뒤 → 오른쪽 위 (rightCol의 맨 위)
        // centerRows의 첫 번째 행 (peekFirst())의 맨 뒤 요소를 꺼내서 (pollLast)
        // rightCol의 맨 앞에 추가 (addFirst)
        rightCol.addFirst(centerRows.peekFirst().pollLast());

        // 3. 오른쪽 아래 (rightCol의 맨 아래) → 가운데 마지막 행의 맨 뒤
        // rightCol의 맨 아래 요소를 꺼내서 (pollLast)
        // centerRows의 마지막 행 (peekLast())의 맨 뒤에 추가 (addLast)
        centerRows.peekLast().addLast(rightCol.pollLast());

        // 4. 가운데 마지막 행의 맨 앞 → 왼쪽 아래 (leftCol의 맨 아래)
        // centerRows의 마지막 행 (peekLast())의 맨 앞 요소를 꺼내서 (pollFirst)
        // leftCol의 맨 뒤에 추가 (addLast)
        leftCol.addLast(centerRows.peekLast().pollFirst());
    }

    // shiftRow 연산: 모든 행을 아래로 한 칸씩 이동 (맨 아래 행이 맨 위로)
    private void shiftRow() {
        // centerRows의 가장 아래 행을 꺼내서 (pollLast) 가장 위로 이동 (addFirst)
        centerRows.addFirst(centerRows.pollLast());
        // leftCol의 가장 아래 요소를 꺼내서 (pollLast) 가장 위로 이동 (addFirst)
        leftCol.addFirst(leftCol.pollLast());
        // rightCol의 가장 아래 요소를 꺼내서 (pollLast) 가장 위로 이동 (addFirst)
        rightCol.addFirst(rightCol.pollLast());
    }

    // 메인 솔루션 메서드: 입력 행렬과 연산들을 받아 최종 행렬 반환
    public int[][] Example20250620_Q118670(int[][] rc, String[] operations) {
        init(rc); // 행렬 초기화 (세 부분으로 분리)

        // 주어진 연산들을 순회하며 각 연산 수행
        for (String op : operations) {
            // 연산 문자열의 첫 글자를 확인하여 'R'이면 rotate(), 'S'이면 shiftRow() 호출
            switch (op.charAt(0)) {
                case 'R' -> rotate(); // Java 14 이상에서 사용 가능한 스위치 표현식
                case 'S' -> shiftRow();
            }
        }

        return getResultMatrix(); // 최종 결과 행렬 반환
    }

}
